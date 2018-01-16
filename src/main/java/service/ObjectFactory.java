
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import entity.CommercialProduit;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProduits_QNAME = new QName("http://service/", "getProduits");
    private final static QName _AjouterCommandeResponse_QNAME = new QName("http://service/", "ajouterCommandeResponse");
    private final static QName _AjouterCommande_QNAME = new QName("http://service/", "ajouterCommande");
    private final static QName _GetProduitsResponse_QNAME = new QName("http://service/", "getProduitsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AjouterCommande }
     * 
     */
    public AjouterCommande createAjouterCommande() {
        return new AjouterCommande();
    }

    /**
     * Create an instance of {@link AjouterCommandeResponse }
     * 
     */
    public AjouterCommandeResponse createAjouterCommandeResponse() {
        return new AjouterCommandeResponse();
    }

    /**
     * Create an instance of {@link GetProduits }
     * 
     */
    public GetProduits createGetProduits() {
        return new GetProduits();
    }

    /**
     * Create an instance of {@link GetProduitsResponse }
     * 
     */
    public GetProduitsResponse createGetProduitsResponse() {
        return new GetProduitsResponse();
    }

    /**
     * Create an instance of {@link CommercialProduit }
     * 
     */
    public CommercialProduit createProduit() {
        return new CommercialProduit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduits }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getProduits")
    public JAXBElement<GetProduits> createGetProduits(GetProduits value) {
        return new JAXBElement<GetProduits>(_GetProduits_QNAME, GetProduits.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "ajouterCommandeResponse")
    public JAXBElement<AjouterCommandeResponse> createAjouterCommandeResponse(AjouterCommandeResponse value) {
        return new JAXBElement<AjouterCommandeResponse>(_AjouterCommandeResponse_QNAME, AjouterCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "ajouterCommande")
    public JAXBElement<AjouterCommande> createAjouterCommande(AjouterCommande value) {
        return new JAXBElement<AjouterCommande>(_AjouterCommande_QNAME, AjouterCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduitsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getProduitsResponse")
    public JAXBElement<GetProduitsResponse> createGetProduitsResponse(GetProduitsResponse value) {
        return new JAXBElement<GetProduitsResponse>(_GetProduitsResponse_QNAME, GetProduitsResponse.class, null, value);
    }

}
