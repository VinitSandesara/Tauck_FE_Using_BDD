package com.tauck.GDriveSpreadSheet;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import cucumber.api.DataTable;
import cucumber.api.Transformer;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.model.Comment;
import gherkin.formatter.model.DataTableRow;

import java.io.IOException;
import java.util.*;

public class readTestDataFromGDriveSpreadSheet extends Transformer<DataTable> {

    static String spreadsheetId = "1BaAz6YARPg95Whj6KDS5k_HdYqFlR5dKW6Uav_Nnd6U";


    @Override
    public DataTable transform(String sheetname) {


        Sheets service = null;
        try {
            service = GoogleSheetApi.getSheetsService();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ValueRange response = null;
        try {
            response = service.spreadsheets().values()
                    .get(spreadsheetId, sheetname)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<List<Object>> excelData = response.getValues();

        List<DataTableRow> dataTableRows = getDataTableRows(excelData);

        DataTable table = getDataTable(dataTableRows);




        return table;
    }




    private static List<DataTableRow> getDataTableRows(List<List<Object>> excelData) {
        List<DataTableRow> dataTableRows = new LinkedList<>();
        int line = 1;

        for (List<Object> list : excelData) {
            Comment commnet = new Comment("", line);
            DataTableRow tableRow = new DataTableRow(Arrays.asList(commnet), (List<String>) (Object) list, line++);
            dataTableRows.add(tableRow);
        }
        return dataTableRows;
    }

    private static DataTable getDataTable(List<DataTableRow> dataTableRows) {
        ParameterInfo parameterInfo = new ParameterInfo(null, null, null, null);
        TableConverter tableConverter = new TableConverter(new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()), parameterInfo);

        DataTable table = new DataTable(dataTableRows, tableConverter);
        return table;
    }




}
