
package model;

/**
 *
 * @author EN
 */
public class Qualification {
    private String concept;
    private float value;

    public Qualification() {
    }

    public Qualification(String concept) {
        this(concept,0);
    }
    

    public Qualification(String concept, float value) {
        this.concept = concept;
        this.value = value;
    }
    

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    
}
