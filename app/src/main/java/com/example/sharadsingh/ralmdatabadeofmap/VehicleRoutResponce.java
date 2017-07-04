package com.example.sharadsingh.ralmdatabadeofmap;



/**
 * Created by sharadsingh on 14/06/17.
 */

public class VehicleRoutResponce extends BaseResponse {
    private VehicleRoutMode []data;
    public VehicleRoutMode[] getData() {
        return data;
    }

    public void setData(VehicleRoutMode[] data) {
        this.data = data;
    }


}
