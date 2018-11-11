package common;

public interface Endpoint {
	String GET_COUNTRY = "http://restcountries.eu/rest/v1/all";
	String GET_NAME = "https://restcountries.eu/rest/v2/name";
	String GET_CAPITAL = "https://restcountries.eu/rest/v2/capital";
	String GET_COUNTRY_invalid = "http://restcountries.eu/rest/v7/all";
	String GET_CURRENCY= "https://restcountries.eu/rest/v2/currency/cop";
	String GET_CURRENCY_invalid= "https://restcountries.eu/rest/v7/currency";
	String GET_LANG = "https://restcountries.eu/rest/v2/lang/es";
	String GET_LANG_invalid = "https://restcountries.eu/rest/v7/lang/es";
}
