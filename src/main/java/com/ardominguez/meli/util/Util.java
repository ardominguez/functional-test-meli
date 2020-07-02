package com.ardominguez.meli.util;

import com.ardominguez.meli.pageobject.Product;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystemException;
import java.util.List;

public class Util {

    public static void writeResultCSV(String filename, List<Product> items) throws FileSystemException, UnsupportedEncodingException, FileNotFoundException {

        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.append("Nombre,Link\n");

        for(Product item :items) {
            writer.append(item.name+","+item.link+"\n");
        }
        writer.flush();
        writer.close();

    };
}
