package com.borjabolufer.recycleviewcontactos;

import android.content.Context;
import android.util.Log;

import com.borjabolufer.recycleviewcontactos.models.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContactParser {

    public static List<Contact> parse(Context context){
        InputStream in = context.getResources().openRawResource(R.raw.contacts);
        List<Contact> result = null;
        try {
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            String content = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener jsonTokener = new JSONTokener(content);
            JSONArray jsonArray = new JSONArray(jsonTokener);
            result = new ArrayList<>(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String firstSurname = jsonObject.getString("firstSurname");
                String secondSurname = jsonObject.getString("secondSurname");
                String phone1 = jsonObject.getString("phone1");
                String phone2 = jsonObject.getString("phone2");
                String email = jsonObject.getString("email");

                result.add(new Contact(name, firstSurname, secondSurname, phone1, phone2, email));
            }
        }catch (IOException | JSONException ioe){
            Log.e(ContactParser.class.getSimpleName(), ioe.getMessage());
            result = null;
        }
        return result;
    }
}
