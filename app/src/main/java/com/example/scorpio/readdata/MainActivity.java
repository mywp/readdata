package com.example.scorpio.readdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private String basicPath="/data/data/com.example.scorpio.writedata/files/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btn_read_private).setOnClickListener(this);
        findViewById(R.id.btn_write_private).setOnClickListener(this);

        findViewById(R.id.btn_read_writeable).setOnClickListener(this);
        findViewById(R.id.btn_write_readable).setOnClickListener(this);

        findViewById(R.id.btn_read_readable).setOnClickListener(this);
        findViewById(R.id.btn_write_writeable).setOnClickListener(this);

        findViewById(R.id.btn_read_readable_writeable).setOnClickListener(this);
        findViewById(R.id.btn_write_readable_writeable).setOnClickListener(this);
    }

    //哪一个空间被点击，v对象就代表被点击的对象
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read_private:
                readFile("private.txt");
                break;
            case R.id.btn_write_private:
                writeFile("private.txt");
                break;
            case R.id.btn_read_readable:
                readFile("readable.txt");
                break;
            case R.id.btn_write_readable:
                readFile("readable.txt");
                break;
            case R.id.btn_read_writeable:
                readFile("writeable.txt");
                break;
            case R.id.btn_write_writeable:
                readFile("writeable.txt");
                break;
            case R.id.btn_read_readable_writeable:
                readFile("readable_writeable.txt");
                break;
            case R.id.btn_write_readable_writeable:
                readFile("readable_writeable.txt");
                break;
            default:
                break;
        }
    }
    
    //读文件
    private void readFile(String fileName){
        try {
            String path=basicPath+fileName;

            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        
            String text=reader.readLine();
            reader.close();
            Toast.makeText(this,"读取成功："+text,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"读取失败："+fileName,Toast.LENGTH_SHORT).show();
        }

    }
    
    private void writeFile(String fileName){
        try {
            String path=basicPath+fileName;
            FileOutputStream fos=new FileOutputStream(path);
            fos.write("嘿嘿嘿，被人黑了".getBytes());
            fos.flush();
            fos.close();
            Toast.makeText(this,"写入成功："+fileName.getBytes(),Toast.LENGTH_SHORT);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "写入失败：" + fileName, Toast.LENGTH_SHORT);
        }
    } 
}
