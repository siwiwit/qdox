package com.thoughtworks.qdox.model.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.thoughtworks.qdox.library.ClassLibrary;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaTypeTest;

public class DefaultTypeTest
    extends JavaTypeTest<DefaultJavaType>
{

    public JavaClass newJavaClass( ClassLibrary library )
    {
        return new DefaultJavaClass(new DefaultJavaSource( library ));
    }

    public DefaultJavaType newType( String fullname )
    {
        return new DefaultJavaType( fullname );
    }

    public DefaultJavaType newType( String fullname, int dimensions )
    {
        return new DefaultJavaType( fullname, dimensions );
    }

    public DefaultJavaType newType( String fullname, int dimensions, JavaClass clazz )
    {
        return new DefaultJavaType( fullname, dimensions );
    }

    @Test
    public void testArrayType()
        throws Exception
    {
        DefaultJavaType type = newType( "int", 1 );
        assertTrue( type.isArray() );
    }

    @Test
    public void testComponentType()
        throws Exception
    {
        assertNull( newType( "int" ).getComponentType() );
        assertEquals( "int", newType( "int", 1 ).getComponentType().getFullyQualifiedName() );
        assertEquals( "long", newType( "long", 3 ).getComponentType().getFullyQualifiedName() );
    }
}