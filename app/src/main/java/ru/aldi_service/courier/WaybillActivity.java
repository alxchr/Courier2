package ru.aldi_service.courier;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class WaybillActivity extends Activity {
    private int i;
    private String sId, sItems="";
    DBHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor c1,c2,c3;
    private String selection;
    private String [] columns = {"item_number"};
    TextView tvWaybill, tvAddressee, tvGeography, tvAddress, tvPhone, tvInfo, tvComment, tvItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waybill);
        Intent intent = getIntent();
        sId = intent.getStringExtra("delivery_id");
        selection="id = '"+sId+"'";
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        c1 = db.query("deliveries", null, selection, null, null, null, null);
        tvWaybill=(TextView) findViewById(R.id.waybill_number);
        tvAddressee=(TextView) findViewById(R.id.addressee);
        tvGeography=(TextView) findViewById(R.id.geography);
        tvAddress=(TextView) findViewById(R.id.address);
        tvInfo=(TextView) findViewById(R.id.info);
        tvPhone=(TextView) findViewById(R.id.phone);
        tvComment=(TextView) findViewById(R.id.comment);
        tvItems=(TextView) findViewById(R.id.items);
        c1.moveToFirst();
        tvWaybill.setText(c1.getString(c1.getColumnIndex("waybill")));
        tvAddressee.setText(c1.getString(c1.getColumnIndex("addressee")));
        tvGeography.setText(c1.getString(c1.getColumnIndex("geography")));
        tvAddress.setText(c1.getString(c1.getColumnIndex("address")));
        tvPhone.setText(c1.getString(c1.getColumnIndex("phone")));
        tvInfo.setText(c1.getString(c1.getColumnIndex("info")));
        tvComment.setText(c1.getString(c1.getColumnIndex("comment")));
        selection="delivery_id = '"+sId+"'";
        c2 = db.query("delivery_items",columns,selection,null,null,null,null);
        if (c2 != null && c2.getCount() > 0) {
            if (c2.moveToFirst()) {
                i=0;
                do {
                    if (i > 0) {
                        sItems += ", ";
                    }
                    sItems += c2.getString(c2.getColumnIndex("item_number"));
                    i++;
                } while (c2.moveToNext());
                if (i > 0) {
                    tvItems.setText(sItems);
                }
            }
        }
    }
}
