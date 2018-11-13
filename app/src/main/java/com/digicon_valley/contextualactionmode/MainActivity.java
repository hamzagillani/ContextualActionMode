package com.digicon_valley.contextualactionmode;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    android.view.ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (actionMode != null) {
                    return false;
                } else {
                    actionMode = MainActivity.this.startActionMode(callback);
                    return true;
                }

                //return false;
            }
        });
    }


    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            MenuInflater menuInflater=getMenuInflater();
            menuInflater.inflate(R.menu.my_menu,menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {

            actionMode.setTitle("1 Item Selected");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() ==R.id.id_delete){
                Toast.makeText(getApplicationContext(),"You really want to delete ?",Toast.LENGTH_SHORT).show();
            return true;
            }else if (menuItem.getItemId()==R.id.id_share){
                Toast.makeText(getApplicationContext(),"You really want to share ?",Toast.LENGTH_SHORT).show();
                return true;


            }

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            actionMode=null;

        }
    };
}