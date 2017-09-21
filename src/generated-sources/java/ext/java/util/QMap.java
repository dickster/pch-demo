package ext.java.util;

import static com.querydsl.core.types.PathMetadataFactory.*;
import java.util.Map;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMap is a Querydsl query type for Map
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMap extends BeanPath<Map<?, ?>> {

    private static final long serialVersionUID = -1383349348L;

    public static final QMap map = new QMap("map");

    public final BooleanPath empty = createBoolean("empty");

    public final NumberPath<Float> loadFactor = createNumber("loadFactor", Float.class);

    public final NumberPath<Integer> threshold = createNumber("threshold", Integer.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMap(String variable) {
        super((Class) Map.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMap(Path<? extends Map> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMap(PathMetadata metadata) {
        super((Class) Map.class, metadata);
    }

}

