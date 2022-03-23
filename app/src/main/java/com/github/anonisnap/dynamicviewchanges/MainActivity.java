package com.github.anonisnap.dynamicviewchanges;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	private List<ItemDisplay> celebs;
	private RecyclerView celebList;
	private ItemDisplayAdapter celebAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}

	private void init() {
		celebList = findViewById(R.id.recycler_view);
		celebList.hasFixedSize();
		celebList.setLayoutManager(new LinearLayoutManager(this));
		celebs = getCelebrities();
		celebAdapter = new ItemDisplayAdapter(celebs);
		celebAdapter.setOnClickListener(celeb -> {
			Snackbar.make(celebList, celebs.indexOf(celeb) + ": " + celeb.getQuote(), Snackbar.LENGTH_SHORT).show();
//			Toast.makeText(this, celeb.getQuote(), Toast.LENGTH_SHORT).show();
		});

		celebList.setAdapter(celebAdapter);
	}

	private List<ItemDisplay> getCelebrities() {
		ArrayList<ItemDisplay> c = new ArrayList<>();
		c.add(new ItemDisplay("Arnold Schwarzenegger",  "Famous Austrian born Actor",                                               'm',"I'll be back",                                                             R.drawable.arnold_schwarznegger).addQuote("Hasta la Vista, Baby").addQuote("Get to the chopper!"));
		c.add(new ItemDisplay("Michael Jackson",        "Singer and Songwriter who had his skin colour changed to a lighter tone",  'm',"Hee Hee",                                                                  R.drawable.michael_jackson));
		c.add(new ItemDisplay("Owen Wilson",            "Actor famous for his \"Wow\"",                                             'm',"Wow",                                                                      R.drawable.owen_wilson));
		c.add(new ItemDisplay("Inugami Korone",         "A popular Japanese V-Tuber",                                               'f',"Yubi Yubi",                                                                R.drawable.inugami_korone));
		c.add(new ItemDisplay("Mario",                  "Well known Italian Plumber",                                               'm',"It's-a me. Mario!",                                                        R.drawable.super_mario));
		c.add(new ItemDisplay("Pikachu",                "Electric Mouse Type Pokemon",                                              'u',"Pika pika",                                                                R.drawable.pikachu));
		c.add(new ItemDisplay("Michael Scott",          "Hardworking member of The Office",                                         'm',"That's what she said",                                                     R.drawable.michael_scott).addQuote("Nooo! God no!"));
		c.add(new ItemDisplay("James May",              "Incredible Cook, and part of the Top Gear Trio",                           'm',"CLARKSOOOOON!",                                                            R.drawable.james_may).addQuote("Cheese").addQuote("I don't look like Susan Boyle!").addQuote("Good News! The Dacia Sandero..."));
		c.add(new ItemDisplay("Susan Boyle",            "Singer from Britain's got Talent",                                         'f',"Nothing is impossible. It can be downright difficult, but not impossible", R.drawable.susan_boyle));
		return c;
	}
}