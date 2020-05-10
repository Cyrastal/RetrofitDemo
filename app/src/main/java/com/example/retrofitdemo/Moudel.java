package com.example.retrofitdemo;

import java.util.List;

public class Moudel {

    /**
     * resultCode : 1
     * data : [{"id":1,"name":"烤鸭","label":"烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭","description":"烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭","icon":"resources/image/1.png","price":88,"restaurant":{"id":1,"icon":"/resources/image/08.jpg","name":"小慕餐厅","description":"美女八折，程序员免费","price":888.8}},{"id":2,"name":"回锅肉","label":"回锅肉回锅肉回锅肉回锅肉回锅肉","description":"回锅肉回锅肉回锅肉回锅肉回锅肉","icon":"resources/image/2.png","price":12.3,"restaurant":{"id":1,"icon":"/resources/image/08.jpg","name":"小慕餐厅","description":"美女八折，程序员免费","price":888.8}},{"id":3,"name":"茄子","label":"茄子茄子茄子茄子茄子茄子茄子茄子茄子茄子茄子茄子","description":"茄子茄子茄子茄子茄子茄子茄子茄子茄子茄子茄子茄子","icon":"resources/image/3.png","price":1,"restaurant":{"id":1,"icon":"/resources/image/08.jpg","name":"小慕餐厅","description":"美女八折，程序员免费","price":888.8}},{"id":4,"name":"宫保鸡丁","label":"宫保鸡丁宫保鸡丁宫保鸡丁宫保鸡丁宫保鸡丁宫保鸡丁","description":"宫保鸡丁宫保鸡丁宫保鸡丁宫保鸡丁宫保鸡丁","icon":"resources/image/4.png","price":0.2,"restaurant":{"id":1,"icon":"/resources/image/08.jpg","name":"小慕餐厅","description":"美女八折，程序员免费","price":888.8}},{"id":5,"name":"香锅","label":"香锅香锅香锅香锅香锅香锅香锅香锅香锅","description":"香锅香锅香锅香锅香锅香锅香锅香锅","icon":"resources/image/5.png","price":12,"restaurant":{"id":1,"icon":"/resources/image/08.jpg","name":"小慕餐厅","description":"美女八折，程序员免费","price":888.8}}]
     */

    private int resultCode;
    private List<DataBean> data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 烤鸭
         * label : 烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭
         * description : 烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭烤鸭
         * icon : resources/image/1.png
         * price : 88
         * restaurant : {"id":1,"icon":"/resources/image/08.jpg","name":"小慕餐厅","description":"美女八折，程序员免费","price":888.8}
         */

        private int id;
        private String name;
        private String label;
        private String description;
        private String icon;
        private Double price;
        private RestaurantBean restaurant;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public RestaurantBean getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(RestaurantBean restaurant) {
            this.restaurant = restaurant;
        }

        public static class RestaurantBean {
            /**
             * id : 1
             * icon : /resources/image/08.jpg
             * name : 小慕餐厅
             * description : 美女八折，程序员免费
             * price : 888.8
             */

            private int id;
            private String icon;
            private String name;
            private String description;
            private double price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }
        }
    }
}
