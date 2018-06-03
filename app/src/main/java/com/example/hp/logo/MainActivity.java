package com.example.hp.logo;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    TextView bigText;
    BlankFragment blankFragment = new BlankFragment();
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    ImageButton leftNav;

    ImageButton rightNav;
    ViewFlipper viewFlipper;
    Intent intent;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[]={R.drawable.poster2,R.drawable.pic1,R.drawable.pic3,R.drawable.poster3};

        image=findViewById(R.id.background_image);
        viewPager=findViewById(R.id.viewpager);

         image.setImageResource(R.drawable.paris7);

         leftNav = findViewById(R.id.left_nav);
         rightNav =findViewById(R.id.right_nav);
        viewFlipper=findViewById(R.id.viewflipper);




        bigText=findViewById(R.id.bigtext);
        bigText.setText("Let's Checkout Our Applications");

         getSupportFragmentManager().beginTransaction().replace(R.id.container,blankFragment).commit();


         adapter=new CustomSwipeAdapter(this, new CustomSwipeAdapter.OnItemClicked() {
             @Override
             public void OnClick(int position) {
                 Toast.makeText(MainActivity.this,"play video",Toast.LENGTH_SHORT).show();

               intent = new Intent(MainActivity.this,VideoActivity.class);
                 startActivity(intent);

             }
         });
         viewPager.setAdapter(adapter);

         leftNav.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int tab = viewPager.getCurrentItem();
                 if (tab > 0) {
                     tab--;
                     viewPager.setCurrentItem(tab);
                 } else if (tab == 0) {
                     viewPager.setCurrentItem(tab);
                 }
             }
         });

         // Images right navigatin
         rightNav.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int tab = viewPager.getCurrentItem();
                 tab++;
                 viewPager.setCurrentItem(tab);
             }
         });


         for(int i=0;i<images.length;i++)
         {
             flipperImages(images[i]);
         }
     }
//in
    private void flipperImages(int image) {

         ImageView imageView = new ImageView(this);
         imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
         viewFlipper.setFlipInterval(2000);
         viewFlipper.setAutoStart(true);
         viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
         viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

         MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

     }
}
