package com.unannoying.app;

import androidx.annotation.NonNull;

public class Keywords {
    String word;
    int risk;
    String category;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @NonNull
    @Override
    public String toString() {
        return "Keyword{" + "word: " + word + "'" + ", risk: " + risk + ", category: " + category + "}";
    }
}


// If you wanna access the data from the json file, you can use this snippet:

// import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;

// String jsonFileString = Utils.getJSONFromAssets(getApplicationContext(), "keywords.json");
// Log.i("data", jsonFileString);

// Gson gson = new Gson();
// Type listUserType = new TypeToken<List<Keywords>>() { }.getType();

// List<Keywords> users = gson.fromJson(jsonFileString, listUserType);
// for (int i = 0; i < 3; i++) {
//     Log.i("data", "> Item " + i + "\n" + users.get(i));
// }