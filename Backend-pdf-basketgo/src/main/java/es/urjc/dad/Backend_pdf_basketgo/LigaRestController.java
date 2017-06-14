package es.urjc.dad.Backend_pdf_basketgo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.core.Base64;

@RestController
public class LigaRestController {
	@Autowired
	private LigaService ligaService;
	
	@RequestMapping(value="/ver-liga", method = RequestMethod.GET)
	public List<Liga> getLiga(){
		return ligaService.getLiga();
	}
	
	@RequestMapping(value = "/ver-liga/{index}", method = RequestMethod.GET)
	public Liga getLiga(@PathVariable("index") long index){
		return ligaService.getLiga(index);
	}
	
	/*@RequestMapping(value = "/verpdf", method = RequestMethod.GET)
	public Liga getLigaNombre(HttpServletResponse response){
		
		 return ligaService.getLigaNombre("Liga1");
	}*/
	
	@RequestMapping(value = "/verpdf/{nombre}", method = RequestMethod.GET)
	public URL getLigaNombre(@PathVariable("nombre") String nombre){
		
		List<Liga> liga = ligaService.getLigaNombre(nombre);
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HHmmss");
		String hora = hourFormat.format(date);
		
		try {
		    Document document = new Document();
		    
			
		    
		    try {
		        PdfWriter.getInstance(document, new FileOutputStream("pdf"+hora+".pdf"));
			} catch (FileNotFoundException fileNotFoundException) {
			    System.out.println("No such file was found to generate the PDF "
			            + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
			}
            
			document.open();
			document.addTitle("Clasificación de "+liga.get(0).getNombre());
			document.addSubject("usando iText");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("BasketGO");
			document.addCreator("BasketGO");
		 
		    // AQUÍ COMPLETAREMOS NUESTRO CÓDIGO PARA GENERAR EL PDF
			
			Chunk chunk = new Chunk("Clasificación "+liga.get(0).getNombre());
			Paragraph parrafo = new Paragraph(chunk);
			document.add(parrafo);
			
			document.add(new Paragraph(""));
			
			PdfPTable tabla = new PdfPTable(4);
			tabla.addCell("Nombre Equipo");
			tabla.addCell("Puntos");
			tabla.addCell("Victorias");
			tabla.addCell("Derrotas");
			for (int i = 0; i < liga.get(0).getClasificacion().getListaClasificacion().size(); i++)
			{
				tabla.addCell(liga.get(0).getClasificacion().getListaClasificacion().get(i).getNombreEquipo());
				tabla.addCell(""+liga.get(0).getClasificacion().getListaClasificacion().get(i).getPuntuacion());
				tabla.addCell(""+liga.get(0).getClasificacion().getListaClasificacion().get(i).getNumeroVictorias());
				tabla.addCell(""+liga.get(0).getClasificacion().getListaClasificacion().get(i).getNumeroDerrotas());
			}
			document.add(tabla);
		    document.close();
		    
		    try {
		    	
		    	// DefaultEndpointsProtocol=https;AccountName=ficherospdf;AccountKey=j06O/hWQZnvc4va+B9d+ujUoCCTL6JHGZfNmhzAGMVm9r+25xh7jaeluKYyN/WTp1yqpYBW2/K6MeBNcuJEVsw==;EndpointSuffix=core.windows.net
		    	
		    	String storageKey="j06O/hWQZnvc4va+B9d+ujUoCCTL6JHGZfNmhzAGMVm9r+25xh7jaeluKYyN/WTp1yqpYBW2/K6MeBNcuJEVsw==;https;AccountName=ficherospdf;AccountKey=j06O/hWQZnvc4va+B9d+ujUoCCTL6JHGZfNmhzAGMVm9r+25xh7jaeluKYyN/WTp1yqpYBW2/K6MeBNcuJEVsw==";
		    	String encodedKey=Base64.encode(storageKey.getBytes());
		    	
		    	String storageConnectionString="DefaultEndpointsProtocol=https;" +
						"AccountName=ficherospdf;" +
						"AccountKey=j06O/hWQZnvc4va+B9d+ujUoCCTL6JHGZfNmhzAGMVm9r+25xh7jaeluKYyN/WTp1yqpYBW2/K6MeBNcuJEVsw==;" +
						";EndpointSuffix=core.windows.net;";
		    	
				CloudStorageAccount account;
				account = CloudStorageAccount.parse(storageConnectionString);
	            CloudBlobClient serviceClient = account.createCloudBlobClient();
	            
	            // Container name must be lower case.
	            CloudBlobContainer container = serviceClient.getContainerReference("mispdf");
	            boolean noexiste=false;
	            
	            noexiste=container.createIfNotExists();

	            if(noexiste){
	            	System.out.println("No existe");
	            }else{
	            	System.out.println("Si existe");
	            }

	            // Upload a pdf file.
	            CloudBlockBlob blob;
				blob = container.getBlockBlobReference("pdf"+hora+".pdf");
				File sourceFile = new File("pdf"+hora+".pdf");
				blob.upload(new FileInputStream(sourceFile), sourceFile.length());

		    } catch (IOException IOException) {
	            System.out.print("IOException encontrada: ");
	            System.out.println(IOException.getMessage());
		    } catch (StorageException storageException) {
				// TODO Auto-generated catch block
		    	System.out.print("storageException encontrada: ");
		    	System.out.println(storageException.getMessage());
		    	System.out.println(storageException.getExtendedErrorInformation());
		    	storageException.printStackTrace();
			} catch (URISyntaxException URISyntaxException) {
				// TODO Auto-generated catch block
				System.out.print("URISyntaxException encontrada: ");
	            System.out.println(URISyntaxException.getMessage());
			} catch (InvalidKeyException invalidKeyException) {
				// TODO Auto-generated catch block
				System.out.print("invalidKeyException encontrada: ");
	            System.out.println(invalidKeyException.getMessage());
			}
		    
		} catch (DocumentException documentException) {
			
		}
		
		URL urlDescarga = new URL("dirección", "https://ficherospdf.blob.core.windows.net/mispdf/pdf"+hora+".pdf");
		
		return urlDescarga;
	}
}
