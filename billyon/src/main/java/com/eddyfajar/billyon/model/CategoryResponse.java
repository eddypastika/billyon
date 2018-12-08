package com.eddyfajar.billyon.model;

public class CategoryResponse extends AuditModel {

    private Long id;
    private String category_name;
    private String image_path;
    private Long store_id;
    private boolean is_error;

    public CategoryResponse() {
    }

    public CategoryResponse(Long id, String category_name, String image_path, Long store_id, boolean is_error) {
        this.id = id;
        this.category_name = category_name;
        this.image_path = image_path;
        this.store_id = store_id;
        this.is_error = is_error;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public boolean isIs_error() {
        return is_error;
    }

    public void setIs_error(boolean is_error) {
        this.is_error = is_error;
    }
}
