import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscrituraXML {
    public static void main(String[] args) {
        try {
            // Crear una instancia del constructor de documentos
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Crear un nuevo documento XML
            Document document = builder.newDocument();
            Element rootElement = document.createElement("coches");
            document.appendChild(rootElement);

            // Añadir coches al XML
            agregarCoche(document, rootElement, "Toyota", "Corolla", 2020, "Blanco", 25000.00);
            agregarCoche(document, rootElement, "Honda", "Civic", 2019, "Azul", 22000.00);

            // Guardar el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("coches_salida.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML creado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para añadir un coche al XML
    private static void agregarCoche(Document doc, Element root, String marca, String modelo, int año, String color, double precio) {
        Element coche = doc.createElement("coche");

        Element marcaElem = doc.createElement("Marca");
        marcaElem.appendChild(doc.createTextNode(marca));
        coche.appendChild(marcaElem);

        Element modeloElem = doc.createElement("Modelo");
        modeloElem.appendChild(doc.createTextNode(modelo));
        coche.appendChild(modeloElem);

        Element añoElem = doc.createElement("Año");
        añoElem.appendChild(doc.createTextNode(String.valueOf(año)));
        coche.appendChild(añoElem);

        Element colorElem = doc.createElement("Color");
        colorElem.appendChild(doc.createTextNode(color));
        coche.appendChild(colorElem);

        Element precioElem = doc.createElement("Precio");
        precioElem.appendChild(doc.createTextNode(String.valueOf(precio)));
        coche.appendChild(precioElem);

        root.appendChild(coche);
    }
}
