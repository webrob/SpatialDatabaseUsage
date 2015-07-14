package com.webrob.spatial.repositories.area;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Robert on 2015-07-14.
 */
@Qualifier @Retention(RUNTIME) @Target({ TYPE, FIELD })
public @interface AreaAnnotation
{
}
