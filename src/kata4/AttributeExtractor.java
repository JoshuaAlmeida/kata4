package kata4;

/**
 *
 * @author usuario
 * @param <Entity>
 * @param <Attribute>
 */
public interface AttributeExtractor<Entity,Attribute> {
    
    public Attribute extract(Entity entity);
    
}
