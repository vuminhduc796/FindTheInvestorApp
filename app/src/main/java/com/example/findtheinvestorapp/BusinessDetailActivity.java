package com.example.findtheinvestorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.findtheinvestorapp.model.BusinessItem;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.squareup.picasso.Picasso;
import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class BusinessDetailActivity extends AppCompatActivity {
    private TextView tv_name;
    private TextView tv_desc;
    private TextView tv_highlight;
    private TextView tv_location;
    private TextView tv_stage;
    private TextView tv_interests;
    private TextView tv_sales;
    private TextView tv_established;
    private TextView tv_serviceProduct;
    private ImageView img_prod;
    private TextView tv_assets;
    private TextView tv_facility;
    private TextView tv_email;
    private TextView tv_phone;

    private BusinessItem selectedItem;

    private BarChart ebit_chart;
    private BarChart roi_chart;
    private BarChart tangible_chart;
    private BarChart intangible_chart;
    private BarChart employee_chart;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_business_detail );
        setUpTextView();
        Intent intent = getIntent ();
        populateTextView(intent);
        setChart();


    }
    private void setChart() {
        ebit_chart = (BarChart) findViewById(R.id.ebit_chart);
        roi_chart = (BarChart) findViewById(R.id.roi_chart);
        intangible_chart = (BarChart) findViewById(R.id.intangible_chart);
        tangible_chart = (BarChart) findViewById(R.id.tangible_chart);
        employee_chart = (BarChart) findViewById(R.id.employee_chart);

        List<BusinessItem.Roi> roiArrayList = selectedItem.getRoiList();
        List<BusinessItem.Ebit> ebitArrayList = selectedItem.getEbitList();
        List<BusinessItem.Employee> employeeList = selectedItem.getEmployeeList();
        List<BusinessItem.IntangibleAsset> intangibleAssetList = selectedItem.getIntangibleAssetList();
        List<BusinessItem.Asset> tangibleArrayList = selectedItem.getAssetList();

        if(intangibleAssetList.size() > 0) {
            ViewGroup.LayoutParams params = intangible_chart.getLayoutParams();
            params.height = 400;
            intangible_chart.setLayoutParams(params);
            setIntangible_chart(intangibleAssetList);
        }
        if(tangibleArrayList.size() > 0) {
            ViewGroup.LayoutParams params = tangible_chart.getLayoutParams();
            params.height = 400;
            tangible_chart.setLayoutParams(params);
            setTangible_chart(tangibleArrayList);
        }
        if(ebitArrayList.size() > 0) {
            ViewGroup.LayoutParams params = ebit_chart.getLayoutParams();
            params.height = 400;
            ebit_chart.setLayoutParams(params);
            setEbit_chart(ebitArrayList);
        }
        if(roiArrayList.size() > 0) {
            ViewGroup.LayoutParams params = ebit_chart.getLayoutParams();
            params.height = 400;
            roi_chart.setLayoutParams(params);
            setRoi_chart(roiArrayList);
        }
        if(employeeList.size() > 0) {
            ViewGroup.LayoutParams params = employee_chart.getLayoutParams();
            params.height = 400;
            employee_chart.setLayoutParams(params);
            setEmployee_chart(employeeList);
        }
    }
    private void setRoi_chart( List<BusinessItem.Roi>array){
        ArrayList xAxisData = new ArrayList();
        ArrayList valueSet1 = new ArrayList();
        int counter = 0;
        for (BusinessItem.Roi prop : array) {
            BarEntry entry1 = new BarEntry(prop.getRoiPercentage() * 1f, counter);
            valueSet1.add(entry1);
            xAxisData.add(prop.getYearNumber().substring(0,4));
            counter += 1;
        }
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "ROI value");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add((IBarDataSet) barDataSet1);
        BarData data = new BarData(xAxisData, dataSets);
        roi_chart.setDescription("");
        roi_chart.setData(data);
        roi_chart.animateXY(2000,2000);
        roi_chart.invalidate();

    }

    private void setEmployee_chart( List<BusinessItem.Employee>array){

        ArrayList xAxisData = new ArrayList();
        ArrayList valueSet1 = new ArrayList();
        int counter = 0;
        for (BusinessItem.Employee prop : array) {
            BarEntry entry1 = new BarEntry(prop.getNumberOfEmployees() * 1f, counter);
            valueSet1.add(entry1);
            xAxisData.add(prop.getYearNumber().substring(0,4));
            counter += 1;
        }
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Total Employee");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add((IBarDataSet) barDataSet1);
        BarData data = new BarData(xAxisData, dataSets);
        employee_chart.setData(data);
        employee_chart.animateXY(2000,2000);
        employee_chart.setDescription("");
        employee_chart.invalidate();
    }



    private void setTangible_chart(List<BusinessItem.Asset> array){
        ArrayList xAxisData = new ArrayList();
        ArrayList valueSet1 = new ArrayList();
        ArrayList valueSet2 = new ArrayList();
        int counter = 0;
        for (BusinessItem.Asset prop : array) {
            BarEntry entry1 = new BarEntry(prop.getMarketValue() * 1f, counter);
            BarEntry entry2 = new BarEntry(prop.getBookValue() * 1f, counter);
            valueSet1.add(entry1);
            valueSet2.add(entry2);
            xAxisData.add(prop.getAssetsName());
            counter += 1;
        }
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Market Value");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Book Value");
        barDataSet2.setColor(Color.rgb(155, 0, 0));
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add((IBarDataSet) barDataSet1);
        dataSets.add((IBarDataSet) barDataSet2);
        BarData data = new BarData(xAxisData, dataSets);
        tangible_chart.setData(data);
        tangible_chart.setDescription("");
        tangible_chart.animateXY(2000,2000);
        tangible_chart.invalidate();
    }

    private void setIntangible_chart(List<BusinessItem.IntangibleAsset> array) {
        ArrayList xAxisData = new ArrayList();
        ArrayList valueSet1 = new ArrayList();
        ArrayList valueSet2 = new ArrayList();
        int counter = 0;
        for (BusinessItem.IntangibleAsset prop : array) {
            BarEntry entry1 = new BarEntry(prop.getMarketValue() * 1f, counter);
            BarEntry entry2 = new BarEntry(prop.getBookValue() * 1f, counter);
            valueSet1.add(entry1);
            valueSet2.add(entry2);
            xAxisData.add(prop.getAssetsName());
            counter += 1;
        }
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Market Value");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Book Value");
        barDataSet2.setColor(Color.rgb(155, 0, 0));
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add((IBarDataSet) barDataSet1);
        dataSets.add((IBarDataSet) barDataSet2);
        BarData data = new BarData(xAxisData, dataSets);
        intangible_chart.setData(data);
        intangible_chart.setDescription("");
        intangible_chart.animateXY(2000,2000);
        intangible_chart.invalidate();
    }
    public void setEbit_chart(List<BusinessItem.Ebit> array) {
        ArrayList xAxisData = new ArrayList();
        ArrayList valueSet1 = new ArrayList();
        int counter = 0;
        for (BusinessItem.Ebit prop : array) {
            BarEntry entry1 = new BarEntry(prop.getEarningAmount() * 1f, counter);
            valueSet1.add(entry1);
            xAxisData.add(prop.getYearNumber().substring(0,4));
            counter += 1;
        }
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "EBIT value");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add((IBarDataSet) barDataSet1);
        BarData data = new BarData(xAxisData, dataSets);
        ebit_chart.setData(data);
        ebit_chart.setDescription("");
        ebit_chart.animateXY(2000,2000);
        ebit_chart.invalidate();
    }

    private void setUpTextView(){
        img_prod = findViewById(R.id.image_view_detail);
        tv_name = findViewById(R.id.text_view_company_name);
        tv_desc = findViewById(R.id.text_view_desc);
        tv_highlight = findViewById(R.id.business_highlight_txt);
        tv_location = findViewById(R.id.location);
        tv_stage = findViewById(R.id.stage);
        tv_interests = findViewById(R.id.interest);
        tv_sales = findViewById(R.id.monthly_sales);
        tv_established = findViewById(R.id.established);
        tv_serviceProduct = findViewById(R.id.service_product);
        tv_assets = findViewById(R.id.assets);
        tv_facility = findViewById(R.id.facility);
        tv_email = findViewById(R.id.email);
        tv_phone = findViewById(R.id.phone_no);
    }
    @SuppressLint("SetTextI18n")
    private void populateTextView(Intent intent){

        selectedItem = (BusinessItem) intent.getSerializableExtra("selectedItem");
        String imgUrl = selectedItem.getMainImage();
        Picasso.with ( this ).load ( imgUrl ).fit ().centerInside ().into ( img_prod );
        tv_name.setText(selectedItem.getCompanyName());
        tv_desc.setText(selectedItem.getProductsAndServices());
        tv_highlight.setText(selectedItem.getBusinessHighlight());
        tv_location.setText("Company Location: " + selectedItem.getCountry());
        tv_stage.setText("Industry Stage: " +selectedItem.getIndustryStage());
        tv_interests.setText("Interests: " + selectedItem.getStringInterest());
        tv_sales.setText("Monthly Sales: "+ selectedItem.getAverageMonthlySalesNumber());
        tv_established.setText("Business Establishment: "+ selectedItem.getBusinessEstablishment());
        tv_serviceProduct.setText("Services and Products: " + selectedItem.getStringProductsAndServiceTags());
        tv_assets.setText("Traceable Assets: "  + selectedItem.getTrackableAsset());
        tv_facility.setText("Facility Overview: "+ selectedItem.getFacilityOverview());
        tv_email.setText("Email: " + selectedItem.getEmail());


    }

}