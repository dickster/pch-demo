package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LayoutHint {

    public LayoutHint() {
    }

    public int numColumns() {
        return 1;
    }

    public boolean labelOverInput() {
        return true;
    }

    // TODO : add whatever else you need here... css themes & styles, required javascript/css files
    // possibly a layoutManager method...name of javascript function that must exist.
    // layoutManager { getLayout(component);   }
    // layout= { row, width, col, offset, sytle/element type}

}
