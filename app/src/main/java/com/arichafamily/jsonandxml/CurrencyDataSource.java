package com.arichafamily.jsonandxml;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.XMLFormatter;

public class CurrencyDataSource {
    public interface OnCurrencyArrivedListener{
        void onCurrenciesArrived(List<Currency> currencies);
    }

    public static void getCurrencies(final OnCurrencyArrivedListener listener) {
        //http://www.boi.org.il/currency.xml
        AsyncTask<String, Integer, List<Currency>> asyncTask = new AsyncTask<String, Integer, List<Currency>>() {
            @Override
            protected List<Currency> doInBackground(String... params) {
                //code that run in the background
                try {
                    String xml = IO.readWebSite("http://www.boi.org.il/currency.xml");
                    List<Currency> currencies = pars(xml);
                    return currencies;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<Currency> currencies) {
                //code that runs on the UI thread
                listener.onCurrenciesArrived(currencies);
            }
        };
        asyncTask.execute();
    }

    private static List<Currency> pars(String xml) {
        List<Currency> currencies = new ArrayList<>();
        Document document = Jsoup.parse(xml);
        Elements elements = document.getElementsByTag("CURRENCY");
        for (Element element : elements) {
            String name = element.getElementsByTag("NAME").first().text();
            int unit = Integer.parseInt(element.getElementsByTag("UNIT").first().text());
            String currencyCode = element.getElementsByTag("CURRENCYCODE").first().text();
            String country = element.getElementsByTag("COUNTRY").first().text();
            double rate = Double.parseDouble(element.getElementsByTag("RATE").first().text());
            double change = Double.parseDouble(element.getElementsByTag("CHANGE").first().text());

            currencies.add(new Currency(name, unit, currencyCode, country, rate, change));
        }
        return currencies;
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
