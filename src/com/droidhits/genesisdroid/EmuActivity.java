

package com.droidhits.genesisdroid;

import com.droidhits.genesisdroid.Emulator;

import com.droidhits.genesisdroid.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



public class EmuActivity extends Activity
{
     private static final String LOG_TAG           = "EmulatorActivity";
     private EmulatorView        _view;
     private int                 _currentSaveState = 0;


     @Override
     public void onCreate(Bundle savedInstanceState)
     {
          Log.d(LOG_TAG, "onCreate()");

          super.onCreate(savedInstanceState);

          // reset input here so we have the emulation layout
          Preferences.loadInputs(this, getApplicationContext());
          
          // start displaying
          _view = new EmulatorView(this, getApplication());
          setContentView(_view);
     }


     @Override
     public boolean onCreateOptionsMenu(Menu myMenu)
     {
          MenuInflater inflater = getMenuInflater();
          inflater.inflate(R.menu.emulator, myMenu);

          return true;
     }


     @Override
     public void onResume()
     {
          super.onResume();

          Log.d(LOG_TAG, "onResume()");

          SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
          boolean audio = prefs.getBoolean(Preferences.PREF_ENABLE_AUDIO, true);
          if (audio)
          {
               AudioPlayer.resume();
          }

          _view.onResume();

          // help android out a bit... seems to be slow at releasing sometimes
          System.gc();
     }


     @Override
     public void onPause()
     {
          Log.d(LOG_TAG, "onPause()");

          super.onPause();

          AudioPlayer.pause();

          _view.onPause();

          Preferences.DoAutoSave(getApplicationContext());
     }


     @Override
     public void onDestroy()
     {
          super.onDestroy();
     }


     @Override
     public void onStop()
     {
          Log.d(LOG_TAG, "onStop()");

          super.onStop();
     }

     
     @Override
public boolean onOptionsItemSelected(MenuItem item)
{
    int id = item.getItemId();
    
    if (id == R.id.menuMenu) {
        this.finish();
        return true;
    } else if (id == R.id.menuSettings) {
        spawnSettings();
        return true;
    } else if (id == R.id.menuLoadROM) {
        spawnFileChooser();
        return true;
    } else if (id == R.id.menuSelectState) {
        return true;
    } else if (id == R.id.menuLoadState) {
        Emulator.loadState(_currentSaveState);
        return true;
    } else if (id == R.id.menuSaveState) {
        Emulator.saveState(_currentSaveState);
        return true;
    } else if (id == R.id.menuResetGame) {
        Emulator.resetGame();
        return true;
    } else if (id == R.id.menuState0) {
        _currentSaveState = 0;
        return true;
    } else if (id == R.id.menuState1) {
        _currentSaveState = 1;
        return true;
    } else if (id == R.id.menuState2) {
        _currentSaveState = 2;
        return true;
    } else if (id == R.id.menuState3) {
        _currentSaveState = 3;
        return true;
    } else if (id == R.id.menuState4) {
        _currentSaveState = 4;
        return true;
    } else if (id == R.id.menuState5) {
        _currentSaveState = 5;
        return true;
    } else if (id == R.id.menuState6) {
        _currentSaveState = 6;
        return true;
    } else if (id == R.id.menuState7) {
        _currentSaveState = 7;
        return true;
    } else if (id == R.id.menuState8) {
        _currentSaveState = 8;
        return true;
    } else if (id == R.id.menuState9) {
        _currentSaveState = 9;
        return true;
    } else {
        return super.onOptionsItemSelected(item);
    }
}

     protected void spawnFileChooser()
     {
          // spawn the file chooser
          Context context = getApplicationContext();
          Intent myIntent = new Intent(EmuActivity.this, FileChooser.class);
          myIntent.putExtra(FileChooser.EXTRA_START_DIR, Preferences.getRomDir(context));
          myIntent.putExtra(FileChooser.EXTRA_EXTENSIONS, Preferences.DEFAULT_ROM_EXTENSIONS);
          myIntent.putExtra(FileChooser.EXTRA_TEMP_DIR, Preferences.getTempDir(context));
          final int result = Preferences.MENU_ROM_SELECT;
          startActivityForResult(myIntent, result);
     }


     protected void spawnSettings()
     {
          // spawn the file chooser
          Intent myIntent = new Intent(EmuActivity.this, SettingsActivity.class);
          final int result = Preferences.MENU_SETTINGS;
          startActivityForResult(myIntent, result);
     }


     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data)
     {
          Log.d(LOG_TAG, "onActivityResult(" + requestCode + ", " + resultCode + ")");

          if (requestCode == Preferences.MENU_SETTINGS)
          {
               _view.queueEvent(new Runnable()
               {
                    public void run()
                    {
                         Preferences.loadPrefs(EmuActivity.this, getApplicationContext());
                         Preferences.loadInputs(EmuActivity.this, getApplicationContext());
                    }
               });
          }
          else if (requestCode == Preferences.MENU_ROM_SELECT)
          {
               String romFile = data.getStringExtra("Filename");
               if (romFile != null)
               {
                    if (Emulator.loadRom(romFile) != 0)
                    {
                         finish();
                    }

                    Preferences.DoAutoLoad(getApplicationContext());
               }
          }
     }

}
