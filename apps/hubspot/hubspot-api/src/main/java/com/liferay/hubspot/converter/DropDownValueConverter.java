/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.hubspot.converter;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Peter Shin
 */
public class DropDownValueConverter {

	public static String getSFLeadCountry(String value) {
		if (equalsCountry(value, "Afghanistan")) {
			return "Afghanistan";
		}
		else if (equalsCountry(value, "Albania")) {
			return "Albania";
		}
		else if (equalsCountry(value, "Algeria")) {
			return "Algeria";
		}
		else if (equalsCountry(value, "American Samoa")) {
			return "American Samoa";
		}
		else if (equalsCountry(value, "Andorra")) {
			return "Andorra";
		}
		else if (equalsCountry(value, "Angola")) {
			return "Angola";
		}
		else if (equalsCountry(value, "Anguilla")) {
			return "Anguilla";
		}
		else if (equalsCountry(value, "Antarctica")) {
			return "Antarctica";
		}
		else if (equalsCountry(value, "Antigua") ||
				 equalsCountry(value, "Antigua and Barbuda")) {

			return "Antigua and Barbuda";
		}
		else if (equalsCountry(value, "Argentina")) {
			return "Argentina";
		}
		else if (equalsCountry(value, "Armenia")) {
			return "Armenia";
		}
		else if (equalsCountry(value, "Aruba")) {
			return "Aruba";
		}
		else if (equalsCountry(value, "Australia")) {
			return "Australia";
		}
		else if (equalsCountry(value, "Austria")) {
			return "Austria";
		}
		else if (equalsCountry(value, "Azerbaijan")) {
			return "Azerbaijan";
		}
		else if (equalsCountry(value, "Bahamas")) {
			return "Bahamas";
		}
		else if (equalsCountry(value, "Bahrain")) {
			return "Bahrain";
		}
		else if (equalsCountry(value, "Bangladesh")) {
			return "Bangladesh";
		}
		else if (equalsCountry(value, "Barbados")) {
			return "Barbados";
		}
		else if (equalsCountry(value, "Belarus")) {
			return "Belarus";
		}
		else if (equalsCountry(value, "Belgium")) {
			return "Belgium";
		}
		else if (equalsCountry(value, "Belize")) {
			return "Belize";
		}
		else if (equalsCountry(value, "Benin")) {
			return "Benin";
		}
		else if (equalsCountry(value, "Bermuda")) {
			return "Bermuda";
		}
		else if (equalsCountry(value, "Bhutan")) {
			return "Bhutan";
		}
		else if (equalsCountry(value, "Bolivia")) {
			return "Bolivia";
		}
		else if (equalsCountry(value, "Bosnia and Herzegovina") ||
				 equalsCountry(value, "Bosnia Herzegovina")) {

			return "Bosnia and Herzegovina";
		}
		else if (equalsCountry(value, "Botswana")) {
			return "Botswana";
		}
		else if (equalsCountry(value, "Bouvet Island")) {
			return "Bouvet Island";
		}
		else if (equalsCountry(value, "Brazil")) {
			return "Brazil";
		}
		else if (equalsCountry(value, "British Indian Ocean Territory")) {
			return "British Indian Ocean Territory";
		}
		else if (equalsCountry(value, "Brunei") ||
				 equalsCountry(value, "Brunei Darussalam")) {

			return "Brunei Darussalam";
		}
		else if (equalsCountry(value, "Bulgaria")) {
			return "Bulgaria";
		}
		else if (equalsCountry(value, "Burkina Faso")) {
			return "Burkina Faso";
		}
		else if (equalsCountry(value, "Burundi")) {
			return "Burundi";
		}
		else if (equalsCountry(value, "Cambodia")) {
			return "Cambodia";
		}
		else if (equalsCountry(value, "Cameroon")) {
			return "Cameroon";
		}
		else if (equalsCountry(value, "Canada")) {
			return "Canada";
		}
		else if (equalsCountry(value, "Cape Verde")) {
			return "Cape Verde";
		}
		else if (equalsCountry(value, "Cayman Islands")) {
			return "Cayman Islands";
		}
		else if (equalsCountry(value, "Central African Republic")) {
			return "Central African Republic";
		}
		else if (equalsCountry(value, "Chad")) {
			return "Chad";
		}
		else if (equalsCountry(value, "Chile")) {
			return "Chile";
		}
		else if (equalsCountry(value, "China")) {
			return "China";
		}
		else if (equalsCountry(value, "Christmas Island")) {
			return "Christmas Island";
		}
		else if (equalsCountry(value, "Cocos (Keeling) Islands")) {
			return "Cocos (Keeling) Islands";
		}
		else if (equalsCountry(value, "Colombia") ||
				 equalsCountry(value, "Columbia")) {

			return "Colombia";
		}
		else if (equalsCountry(value, "Comoros")) {
			return "Comoros";
		}
		else if (equalsCountry(value, "Congo")) {
			return "Congo";
		}
		else if (equalsCountry(value, "Cook Islands")) {
			return "Cook Islands";
		}
		else if (equalsCountry(value, "Costa Rica")) {
			return "Costa Rica";
		}
		else if (equalsCountry(value, "Cote d'Ivoire") ||
				 equalsCountry(value, "Ivory Coast")) {

			return "Cote d'Ivoire";
		}
		else if (equalsCountry(value, "Croatia")) {
			return "Croatia";
		}
		else if (equalsCountry(value, "Cyprus")) {
			return "Cyprus";
		}
		else if (equalsCountry(value, "Czech Republic")) {
			return "Czech Republic";
		}
		else if (equalsCountry(value, "Denmark")) {
			return "Denmark";
		}
		else if (equalsCountry(value, "Djibouti")) {
			return "Djibouti";
		}
		else if (equalsCountry(value, "Dominica")) {
			return "Dominica";
		}
		else if (equalsCountry(value, "Dominican Republic")) {
			return "Dominican Republic";
		}
		else if (equalsCountry(value, "East Timor")) {
			return "East Timor";
		}
		else if (equalsCountry(value, "Ecuador")) {
			return "Ecuador";
		}
		else if (equalsCountry(value, "Egypt")) {
			return "Egypt";
		}
		else if (equalsCountry(value, "El Salvador")) {
			return "El Salvador";
		}
		else if (equalsCountry(value, "Equatorial Guinea")) {
			return "Equatorial Guinea";
		}
		else if (equalsCountry(value, "Eritrea")) {
			return "Eritrea";
		}
		else if (equalsCountry(value, "Estonia")) {
			return "Estonia";
		}
		else if (equalsCountry(value, "Ethiopia")) {
			return "Ethiopia";
		}
		else if (equalsCountry(value, "Falkland Islands (Malvinas)")) {
			return "Falkland Islands (Malvinas)";
		}
		else if (equalsCountry(value, "Faroe Islands")) {
			return "Faroe Islands";
		}
		else if (equalsCountry(value, "Fiji")) {
			return "Fiji";
		}
		else if (equalsCountry(value, "Finland")) {
			return "Finland";
		}
		else if (equalsCountry(value, "France")) {
			return "France";
		}
		else if (equalsCountry(value, "France, Metropolitan")) {
			return "France, Metropolitan";
		}
		else if (equalsCountry(value, "French Guiana")) {
			return "French Guiana";
		}
		else if (equalsCountry(value, "French Polynesia")) {
			return "French Polynesia";
		}
		else if (equalsCountry(value, "French Southern Territories")) {
			return "French Southern Territories";
		}
		else if (equalsCountry(value, "Gabon")) {
			return "Gabon";
		}
		else if (equalsCountry(value, "Gambia")) {
			return "Gambia";
		}
		else if (equalsCountry(value, "Georgia")) {
			return "Georgia";
		}
		else if (equalsCountry(value, "Germany")) {
			return "Germany";
		}
		else if (equalsCountry(value, "Ghana")) {
			return "Ghana";
		}
		else if (equalsCountry(value, "Gibraltar")) {
			return "Gibraltar";
		}
		else if (equalsCountry(value, "Greece")) {
			return "Greece";
		}
		else if (equalsCountry(value, "Greenland")) {
			return "Greenland";
		}
		else if (equalsCountry(value, "Grenada")) {
			return "Grenada";
		}
		else if (equalsCountry(value, "Guadeloupe")) {
			return "Guadeloupe";
		}
		else if (equalsCountry(value, "Guam")) {
			return "Guam";
		}
		else if (equalsCountry(value, "Guatemala")) {
			return "Guatemala";
		}
		else if (equalsCountry(value, "Guinea")) {
			return "Guinea";
		}
		else if (equalsCountry(value, "Guinea-Bissau")) {
			return "Guinea-Bissau";
		}
		else if (equalsCountry(value, "Guyana")) {
			return "Guyana";
		}
		else if (equalsCountry(value, "Haiti")) {
			return "Haiti";
		}
		else if (equalsCountry(value, "Heard Island and McDonald Islands")) {
			return "Heard Island and McDonald Islands";
		}
		else if (equalsCountry(value, "Honduras")) {
			return "Honduras";
		}
		else if (equalsCountry(value, "Hong Kong")) {
			return "Hong Kong";
		}
		else if (equalsCountry(value, "Hungary")) {
			return "Hungary";
		}
		else if (equalsCountry(value, "Iceland")) {
			return "Iceland";
		}
		else if (equalsCountry(value, "India")) {
			return "India";
		}
		else if (equalsCountry(value, "Indonesia")) {
			return "Indonesia";
		}
		else if (equalsCountry(value, "Ireland")) {
			return "Ireland";
		}
		else if (equalsCountry(value, "Israel")) {
			return "Israel";
		}
		else if (equalsCountry(value, "Italy")) {
			return "Italy";
		}
		else if (equalsCountry(value, "Jamaica")) {
			return "Jamaica";
		}
		else if (equalsCountry(value, "Japan")) {
			return "Japan";
		}
		else if (equalsCountry(value, "Jordan")) {
			return "Jordan";
		}
		else if (equalsCountry(value, "Kazakhstan")) {
			return "Kazakhstan";
		}
		else if (equalsCountry(value, "Kenya")) {
			return "Kenya";
		}
		else if (equalsCountry(value, "Kiribati")) {
			return "Kiribati";
		}
		else if (equalsCountry(value, "Kuwait")) {
			return "Kuwait";
		}
		else if (equalsCountry(value, "Kyrgyzstan")) {
			return "Kyrgyzstan";
		}
		else if (equalsCountry(value, "Lao People's Democratic Republic") ||
				 equalsCountry(value, "Laos")) {

			return "Lao People's Democratic Republic";
		}
		else if (equalsCountry(value, "Latin America")) {
			return "Latin America";
		}
		else if (equalsCountry(value, "Latvia")) {
			return "Latvia";
		}
		else if (equalsCountry(value, "Lebanon")) {
			return "Lebanon";
		}
		else if (equalsCountry(value, "Lesotho")) {
			return "Lesotho";
		}
		else if (equalsCountry(value, "Liberia")) {
			return "Liberia";
		}
		else if (equalsCountry(value, "Liechtenstein")) {
			return "Liechtenstein";
		}
		else if (equalsCountry(value, "Lithuania")) {
			return "Lithuania";
		}
		else if (equalsCountry(value, "Luxembourg")) {
			return "Luxembourg";
		}
		else if (equalsCountry(value, "Macau")) {
			return "Macau";
		}
		else if (equalsCountry(value, "Macedonia")) {
			return "Macedonia";
		}
		else if (equalsCountry(value, "Madagascar")) {
			return "Madagascar";
		}
		else if (equalsCountry(value, "Malawi")) {
			return "Malawi";
		}
		else if (equalsCountry(value, "Malaysia")) {
			return "Malaysia";
		}
		else if (equalsCountry(value, "Maldives")) {
			return "Maldives";
		}
		else if (equalsCountry(value, "Mali")) {
			return "Mali";
		}
		else if (equalsCountry(value, "Malta")) {
			return "Malta";
		}
		else if (equalsCountry(value, "Marshall Islands")) {
			return "Marshall Islands";
		}
		else if (equalsCountry(value, "Martinique")) {
			return "Martinique";
		}
		else if (equalsCountry(value, "Mauritania")) {
			return "Mauritania";
		}
		else if (equalsCountry(value, "Mauritius")) {
			return "Mauritius";
		}
		else if (equalsCountry(value, "Mayotte")) {
			return "Mayotte";
		}
		else if (equalsCountry(value, "Mexico")) {
			return "Mexico";
		}
		else if (equalsCountry(value, "Micronesia (Federated States of)")) {
			return "Micronesia (Federated States of)";
		}
		else if (equalsCountry(value, "Moldova") ||
				 equalsCountry(value, "Moldova, Republic of")) {

			return "Moldova, Republic of";
		}
		else if (equalsCountry(value, "Monaco")) {
			return "Monaco";
		}
		else if (equalsCountry(value, "Mongolia")) {
			return "Mongolia";
		}
		else if (equalsCountry(value, "Montenegro")) {
			return "Montenegro";
		}
		else if (equalsCountry(value, "Montserrat")) {
			return "Montserrat";
		}
		else if (equalsCountry(value, "Morocco")) {
			return "Morocco";
		}
		else if (equalsCountry(value, "Mozambique")) {
			return "Mozambique";
		}
		else if (equalsCountry(value, "Burma Myanmar") ||
				 equalsCountry(value, "Myanmar")) {

			return "Myanmar";
		}
		else if (equalsCountry(value, "Namibia")) {
			return "Namibia";
		}
		else if (equalsCountry(value, "Nauru")) {
			return "Nauru";
		}
		else if (equalsCountry(value, "Nepal")) {
			return "Nepal";
		}
		else if (equalsCountry(value, "Netherlands")) {
			return "Netherlands";
		}
		else if (equalsCountry(value, "Netherlands Antilles")) {
			return "Netherlands Antilles";
		}
		else if (equalsCountry(value, "New Caledonia")) {
			return "New Caledonia";
		}
		else if (equalsCountry(value, "New Zealand")) {
			return "New Zealand";
		}
		else if (equalsCountry(value, "Nicaragua")) {
			return "Nicaragua";
		}
		else if (equalsCountry(value, "Niger")) {
			return "Niger";
		}
		else if (equalsCountry(value, "Nigeria")) {
			return "Nigeria";
		}
		else if (equalsCountry(value, "Niue")) {
			return "Niue";
		}
		else if (equalsCountry(value, "Norfolk Island")) {
			return "Norfolk Island";
		}
		else if (equalsCountry(value, "Northern Mariana Islands")) {
			return "Northern Mariana Islands";
		}
		else if (equalsCountry(value, "Norway")) {
			return "Norway";
		}
		else if (equalsCountry(value, "Oman")) {
			return "Oman";
		}
		else if (equalsCountry(value, "Pakistan")) {
			return "Pakistan";
		}
		else if (equalsCountry(value, "Palau")) {
			return "Palau";
		}
		else if (equalsCountry(value, "Panama")) {
			return "Panama";
		}
		else if (equalsCountry(value, "Papua New Guinea")) {
			return "Papua New Guinea";
		}
		else if (equalsCountry(value, "Paraguay")) {
			return "Paraguay";
		}
		else if (equalsCountry(value, "Peru")) {
			return "Peru";
		}
		else if (equalsCountry(value, "Philippines")) {
			return "Philippines";
		}
		else if (equalsCountry(value, "Pitcairn")) {
			return "Pitcairn";
		}
		else if (equalsCountry(value, "Poland")) {
			return "Poland";
		}
		else if (equalsCountry(value, "Portugal")) {
			return "Portugal";
		}
		else if (equalsCountry(value, "Puerto Rico")) {
			return "Puerto Rico";
		}
		else if (equalsCountry(value, "Qatar")) {
			return "Qatar";
		}
		else if (equalsCountry(value, "Reunion") ||
				 equalsCountry(value, "Reunion Island")) {

			return "Reunion";
		}
		else if (equalsCountry(value, "Romania")) {
			return "Romania";
		}
		else if (equalsCountry(value, "Russia") ||
				 equalsCountry(value, "Russian Federation")) {

			return "Russian Federation";
		}
		else if (equalsCountry(value, "Rwanda")) {
			return "Rwanda";
		}
		else if (equalsCountry(value, "Saint Helena")) {
			return "Saint Helena";
		}
		else if (equalsCountry(value, "Saint Kitts and Nevis")) {
			return "Saint Kitts and Nevis";
		}
		else if (equalsCountry(value, "Saint Lucia")) {
			return "Saint Lucia";
		}
		else if (equalsCountry(value, "Saint Pierre and Miquelon")) {
			return "Saint Pierre and Miquelon";
		}
		else if (equalsCountry(value, "Saint Vincent and the Grenadines")) {
			return "Saint Vincent and the Grenadines";
		}
		else if (equalsCountry(value, "Samoa") ||
				 equalsCountry(value, "Western Samoa")) {

			return "Samoa";
		}
		else if (equalsCountry(value, "San Marino")) {
			return "San Marino";
		}
		else if (equalsCountry(value, "Sao Tome and Principe")) {
			return "Sao Tome and Principe";
		}
		else if (equalsCountry(value, "Saudi Arabia")) {
			return "Saudi Arabia";
		}
		else if (equalsCountry(value, "Senegal")) {
			return "Senegal";
		}
		else if (equalsCountry(value, "Serbia")) {
			return "Serbia";
		}
		else if (equalsCountry(value, "Seychelles")) {
			return "Seychelles";
		}
		else if (equalsCountry(value, "Sierra Leone")) {
			return "Sierra Leone";
		}
		else if (equalsCountry(value, "Singapore")) {
			return "Singapore";
		}
		else if (equalsCountry(value, "Slovakia")) {
			return "Slovakia";
		}
		else if (equalsCountry(value, "Slovenia")) {
			return "Slovenia";
		}
		else if (equalsCountry(value, "Solomon Islands")) {
			return "Solomon Islands";
		}
		else if (equalsCountry(value, "Somalia")) {
			return "Somalia";
		}
		else if (equalsCountry(value, "South Africa")) {
			return "South Africa";
		}
		else if (equalsCountry(
					value, "South Georgia and the South Sandwich Island")) {

			return "South Georgia and the South Sandwich Island";
		}
		else if (equalsCountry(value, "South Korea")) {
			return "South Korea";
		}
		else if (equalsCountry(value, "Spain")) {
			return "Spain";
		}
		else if (equalsCountry(value, "Sri Lanka")) {
			return "Sri Lanka";
		}
		else if (equalsCountry(value, "Suriname")) {
			return "Suriname";
		}
		else if (equalsCountry(value, "Svalbard and Jan Mayen Islands")) {
			return "Svalbard and Jan Mayen Islands";
		}
		else if (equalsCountry(value, "Swaziland")) {
			return "Swaziland";
		}
		else if (equalsCountry(value, "Sweden")) {
			return "Sweden";
		}
		else if (equalsCountry(value, "Switzerland")) {
			return "Switzerland";
		}
		else if (equalsCountry(value, "Taiwan") ||
				 equalsCountry(value, "Taiwan, Republic of China")) {

			return "Taiwan, Republic of China";
		}
		else if (equalsCountry(value, "Tajikistan")) {
			return "Tajikistan";
		}
		else if (equalsCountry(value, "Tanzania") ||
				 equalsCountry(value, "Tanzania, United Republic of")) {

			return "Tanzania, United Republic of";
		}
		else if (equalsCountry(value, "Thailand")) {
			return "Thailand";
		}
		else if (equalsCountry(value, "Togo")) {
			return "Togo";
		}
		else if (equalsCountry(value, "Tokelau")) {
			return "Tokelau";
		}
		else if (equalsCountry(value, "Tonga")) {
			return "Tonga";
		}
		else if (equalsCountry(value, "Trinidad and Tobago")) {
			return "Trinidad and Tobago";
		}
		else if (equalsCountry(value, "Tunisia")) {
			return "Tunisia";
		}
		else if (equalsCountry(value, "Turkey")) {
			return "Turkey";
		}
		else if (equalsCountry(value, "Turkmenistan")) {
			return "Turkmenistan";
		}
		else if (equalsCountry(value, "Turks and Caicos Islands")) {
			return "Turks and Caicos Islands";
		}
		else if (equalsCountry(value, "Tuvalu")) {
			return "Tuvalu";
		}
		else if (equalsCountry(value, "Uganda")) {
			return "Uganda";
		}
		else if (equalsCountry(value, "Ukraine")) {
			return "Ukraine";
		}
		else if (equalsCountry(value, "United Arab Emirates")) {
			return "United Arab Emirates";
		}
		else if (equalsCountry(value, "United Kingdom")) {
			return "United Kingdom";
		}
		else if (equalsCountry(value, "United States")) {
			return "United States";
		}
		else if (equalsCountry(value, "United States Minor Outlying Islands")) {
			return "United States Minor Outlying Islands";
		}
		else if (equalsCountry(value, "Uruguay")) {
			return "Uruguay";
		}
		else if (equalsCountry(value, "Uzbekistan")) {
			return "Uzbekistan";
		}
		else if (equalsCountry(value, "Vanuatu")) {
			return "Vanuatu";
		}
		else if (equalsCountry(value, "Vatican City State (Holy See)")) {
			return "Vatican City State (Holy See)";
		}
		else if (equalsCountry(value, "Venezuela")) {
			return "Venezuela";
		}
		else if (equalsCountry(value, "Viet Nam") ||
				 equalsCountry(value, "Vietnam")) {

			return "Vietnam";
		}
		else if (equalsCountry(value, "Virgin Islands (British)")) {
			return "Virgin Islands (British)";
		}
		else if (equalsCountry(value, "Virgin Islands (U.S.)")) {
			return "Virgin Islands (U.S.)";
		}
		else if (equalsCountry(value, "Wallis and Futuna Islands")) {
			return "Wallis and Futuna Islands";
		}
		else if (equalsCountry(value, "Western Sahara")) {
			return "Western Sahara";
		}
		else if (equalsCountry(value, "Yemen")) {
			return "Yemen";
		}
		else if (equalsCountry(value, "Yugoslavia")) {
			return "Yugoslavia";
		}
		else if (equalsCountry(value, "Zaire")) {
			return "Zaire";
		}
		else if (equalsCountry(value, "Zambia")) {
			return "Zambia";
		}
		else if (equalsCountry(value, "Zimbabwe")) {
			return "Zimbabwe";
		}

		if (equalsCountry(value, "Cuba") ||
			equalsCountry(value, "Iran") ||
			equalsCountry(value, "Iraq") ||
			equalsCountry(value, "Libya") ||
			equalsCountry(value, "North Korea") ||
			equalsCountry(value, "Palestine") ||
			equalsCountry(value, "Sudan") ||
			equalsCountry(value, "Syria") ||
			Validator.isNull(value)) {

			return "Antarctica";
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Bad lead country: " + value);
		}

		return "Antarctica";
	}

	public static String getSFLeadDepartment(String value) {
		if (Validator.isNull(value)) {
			return "Other";
		}

		if (equals(value, "Business - Finance") || equals(value, "Finance")) {
			return "Business - Finance";
		}
		else if (equals(value, "Business - HR") || equals(value, "HR")) {
			return "Business - HR";
		}
		else if (equals(value, "Business - Legal/Procurement") ||
				 equals(value, "Legal/Procurement")) {

			return "Business - Legal/Procurement";
		}
		else if (equals(value, "Business - Marketing") ||
				 equals(value, "Marketing")) {

			return "Business - Marketing";
		}
		else if (equals(value, "Business - Operations") ||
				 equals(value, "Operations")) {

			return "Business - Operations";
		}
		else if (equals(value, "Business - Sales") || equals(value, "Sales")) {
			return "Business - Sales";
		}
		else if (equals(value, "Other")) {
			return "Other";
		}
		else if (equals(value, "Technical - Development/Engineering") ||
				 equals(value, "Development/Engineering")) {

			return "Technical - Development/Engineering";
		}
		else if (equals(value, "Technical - IT/Support") ||
				 equals(value, "IT/Support")) {

			return "Technical - IT/Support";
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Bad lead department: " + value);
		}

		return "Other";
	}

	public static String getSFLeadIndustry(String value) {
		if (Validator.isNull(value)) {
			return "Unknown";
		}

		if (equals(value, "Aerospace & Defense")) {
			return "Aerospace & Defense";
		}
		else if (equals(value, "Agriculture")) {
			return "Agriculture";
		}
		else if (equals(value, "Automotive")) {
			return "Automotive";
		}
		else if (equals(value, "Consulting") ||
				 equals(value, "Consultant Contractor")) {

			return "Consulting";
		}
		else if (equals(value, "Consumer Products")) {
			return "Consumer Products";
		}
		else if (equals(value, "Education")) {
			return "Education";
		}
		else if (equals(value, "Energy")) {
			return "Energy";
		}
		else if (equals(value, "Financial Services")) {
			return "Financial Services";
		}
		else if (equals(value, "Government")) {
			return "Government";
		}
		else if (equals(value, "Healthcare")) {
			return "Healthcare";
		}
		else if (equals(value, "Hospitality / Leisure")) {
			return "Hospitality / Leisure";
		}
		else if (equals(value, "Insurance")) {
			return "Insurance";
		}
		else if (equals(value, "Manufacturing")) {
			return "Manufacturing";
		}
		else if (equals(value, "Media / Marketing")) {
			return "Media / Marketing";
		}
		else if (equals(value, "Not For Profit / NGO")) {
			return "Not For Profit / NGO";
		}
		else if (equals(value, "Other")) {
			return "Other";
		}
		else if (equals(value, "Pharmaceuticals")) {
			return "Pharmaceuticals";
		}
		else if (equals(value, "Professional Services")) {
			return "Professional Services";
		}
		else if (equals(value, "Technology")) {
			return "Technology";
		}
		else if (equals(value, "Telecommunications")) {
			return "Telecommunications";
		}
		else if (equals(value, "Transportation")) {
			return "Transportation";
		}
		else if (equals(value, "Utilities")) {
			return "Utilities";
		}
		else if (equals(value, "Unknown")) {
			return "Unknown";
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Bad lead industry: " + value);
		}

		return "Unknown";
	}

	public static String getSFLeadRole(String value) {
		if (Validator.isNull(value)) {
			return "Other";
		}

		if (equals(value, "Account Manager") ||
			equals(value, "Administrator") ||
			equals(value, "Portal Administrator")) {

			return "Administrator";
		}
		else if (equals(value, "Analyst") ||
				 equals(value, "Associate/Analyst")) {

			return "Associate/Analyst";
		}
		else if (equals(value, "Architect") ||
				 equals(value, "C-Level/VP/Executive") ||
				 equals(value, "C-Level/Executive/VP")) {

			return "C-Level/Executive/VP";
		}
		else if (equals(value, "Developer") ||
				 equals(value, "Developer/Engineer") ||
				 equals(value, "Engineering") ||
				 equals(value, "IT") ||
				 equals(value, "Programmer")) {

			return "Developer/Engineer";
		}
		else if (equals(value, "Director") ||
				 equals(value, "Director/Manager") ||
				 equals(value, "Purchasing/Finance")) {

			return "Director/Manager";
		}
		else if (equals(value, "Contractor/Consultant") ||
				 equals(value, "Independent Contractor")) {

			return "Independent Contractor";
		}
		else if (equals(value, "Other")) {
			return "Other";
		}
		else if (equals(value, "Business Development") ||
				 equals(value, "Logistics") ||
				 equals(value, "Management") ||
				 equals(value, "Operations Administration") ||
				 equals(value, "Project Manager")) {

			return "Project Manager";
		}
		else if (equals(value, "Student")) {
			return "Student";
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Bad lead role: " + value);
		}

		return "Other";
	}

	protected static boolean equals(String value, String key) {
		if (Validator.isNull(value)) {
			return false;
		}

		if (StringUtil.equalsIgnoreCase(value, key)) {
			return true;
		}

		// C-Level / Executive/VP --> C-Level / Executive / VP

		String formattedKey = StringUtil.replace(
			key,
			new String[] {
				" / ", StringPool.FORWARD_SLASH
			},
			new String[] {
				StringPool.FORWARD_SLASH, " / "
			}
		);

		if (StringUtil.equalsIgnoreCase(value, formattedKey)) {
			return true;
		}

		// C-Level / Executive/VP --> C-Level/Executive/VP

		formattedKey = StringUtil.replace(key, " / ", StringPool.FORWARD_SLASH);

		if (StringUtil.equalsIgnoreCase(value, formattedKey)) {
			return true;
		}

		// C-Level / Executive/VP --> c-level-executive-vp

		formattedKey = StringUtil.replace(
			StringUtil.toLowerCase(key),
			new String[] {
				" / ", StringPool.AMPERSAND, StringPool.APOSTROPHE,
				StringPool.CLOSE_PARENTHESIS, StringPool.COMMA_AND_SPACE,
				StringPool.FORWARD_SLASH, StringPool.OPEN_PARENTHESIS,
				StringPool.PERIOD, StringPool.SPACE
			},
			new String[] {
				StringPool.FORWARD_SLASH, "and", StringPool.DASH,
				StringPool.BLANK, StringPool.DASH, StringPool.DASH,
				StringPool.BLANK, StringPool.BLANK, StringPool.DASH
			}
		);

		if (StringUtil.equalsIgnoreCase(value, formattedKey)) {
			return true;
		}

		return false;
	}

	protected static boolean equalsCountry(String value, String key) {
		if (equals(value, key)) {
			return true;
		}

		// United States --> United States,

		if (StringUtil.startsWith(
				StringUtil.toLowerCase(value),
				StringUtil.toLowerCase(key.concat(StringPool.COMMA)))) {

			return true;
		}

		// France, Metropolitan --> France[$LIFERAY_EXPANDO_COMMA$] Metropolitan

		String formattedKey = StringUtil.replace(
			key, StringPool.COMMA, "[$LIFERAY_EXPANDO_COMMA$]");

		if (StringUtil.equalsIgnoreCase(value, formattedKey)) {
			return true;
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(
		DropDownValueConverter.class);

}