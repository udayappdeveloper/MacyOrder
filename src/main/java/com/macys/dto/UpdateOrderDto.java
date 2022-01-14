package com.macys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateOrderDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("orderstatus")
    private String status;

    public UpdateOrderDto() {
    }

    public UpdateOrderDto(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "UpdateOrderDto [id=" + id + ", status=" + status + "]";
	}

	
   
}
