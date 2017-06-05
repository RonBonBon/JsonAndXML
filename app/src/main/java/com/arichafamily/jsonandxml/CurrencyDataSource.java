package com.arichafamily.jsonandxml;

public class CurrencyDataSource {

    public static void getCurrencies() {
        //http://www.boi.org.il/currency.xml
        
    }

    //inner class POJO
    public static class Currency {
        private final String name;
        private final int unit;
        private final String currencyCode;
        private final String country;
        private final double rate;
        private final double change;

        public Currency(String name, int unit, String currencyCode, String country, double rate, double change) {
            this.name = name;
            this.unit = unit;
            this.currencyCode = currencyCode;
            this.country = country;
            this.rate = rate;
            this.change = change;
        }

        public String getName() {
            return name;
        }

        public int getUnit() {
            return unit;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public String getCountry() {
            return country;
        }

        public double getRate() {
            return rate;
        }

        public double getChange() {
            return change;
        }

        @Override
        public String toString() {
            return "Currency{" +
                    "name='" + name + '\'' +
                    ", unit=" + unit +
                    ", currencyCode='" + currencyCode + '\'' +
                    ", country='" + country + '\'' +
                    ", rate=" + rate +
                    ", change=" + change +
                    '}';
        }
    }
}
