<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Dodaj namestaj</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append Ã¢ÂÂ#!watchÃ¢ÂÂ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
	<link href="css/addProductStyle.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/smoke.min.js"></script>
	<script type="text/javascript" src="js/addProductScripts.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="js/callback.js"></script>
	<script type="text/javascript" src="js/loginCheckScript.js"></script>
	
	
</head>

<body>

		<input type="hidden" id="user_id" value="${user}"></input>


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="text-info">
			Black Magic Woman - PRODAVNICA NAMESTAJA
			</h2>
			<h4 class="text-info"> Rad sa namestajem - dodavanje namestaja</h4>
			<br>
			<br>
			<form id="back_form" action="ProductStartServlet" method="post">
						<input type="hidden" name="user_id" value="${user}"></input>
			</form>
			<button id="rad_saloni" class="btn btn-default" type="submit" form="back_form">
							 Povratak
			</button> 
			
			<br>			
			<br>
			<form  id="coki" role="form" method="post" action="ProductStartServlet">
				
				<!-- CODE input-->
				<div class="form-group">
				  <label  for="textinput">Sifra namestaja</label>  
				  <div>
				  <input id="code" name="code" placeholder="Unesite sifru namestaja" class="form-control input-md" smk-type="number" minlength="3" maxlength="9"  type="text" required>  
				  </div>
				</div>
				
				<!-- NAZIV input-->
				<div class="form-group">
				  <label  for="textinput">Naziv namestaja</label>  
				  <div>
				  <input id="name" name="name" placeholder="Unesite naziv namestaja" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				
				<!-- BOJA input-->
				<div class="form-group">
				  <label  for="textinput">Naziv boje</label>  
				  <div>
				         <select id="color" name="color" class="form-control" required>
							<option value="">Izaberite boju</option>
							<option value="crna">crna</option>
							<option value="plava">plava</option>
							<option value="crna">crna</option>
							<option value="braon">braon</option>
							<option value="siva">siva</option>
							<option value="zelena">zelena</option>
							<option value="narandzasta">narandzasta</option>
							<option value="ruzicasta">ruzicasta</option>
							<option value="purpurna">purpurna</option>
							<option value="crvena">crvena</option>
							<option value="bela">bela</option>
							<option value="zuta">zuta</option>
						</select>
 
				  </div>
				</div>
				
				
				<!-- BOJA input-->
				<div class="form-group">
				  <label  for="textinput">Zemlja porekla</label>  
				  <div>
				         <select id="origin" name="origin" class="form-control" required>
							<option value="">Izaberite</option>
							<option value="Afghanistan">Afghanistan</option>
							<option value="Åland Islands">Åland Islands</option>
							<option value="Albania">Albania</option>
							<option value="Algeria">Algeria</option>
							<option value="American Samoa">American Samoa</option>
							<option value="Andorra">Andorra</option>
							<option value="Angola">Angola</option>
							<option value="Anguilla">Anguilla</option>
							<option value="Antarctica">Antarctica</option>
							<option value="Antigua and Barbuda">Antigua and Barbuda</option>
							<option value="Argentina">Argentina</option>
							<option value="Armenia">Armenia</option>
							<option value="Aruba">Aruba</option>
							<option value="Australia">Australia</option>
							<option value="Austria">Austria</option>
							<option value="Azerbaijan">Azerbaijan</option>
							<option value="Bahamas">Bahamas</option>
							<option value="Bahrain">Bahrain</option>
							<option value="Bangladesh">Bangladesh</option>
							<option value="Barbados">Barbados</option>
							<option value="Belarus">Belarus</option>
							<option value="Belgium">Belgium</option>
							<option value="Belize">Belize</option>
							<option value="Benin">Benin</option>
							<option value="Bermuda">Bermuda</option>
							<option value="Bhutan">Bhutan</option>
							<option value="Bolivia">Bolivia</option>
							<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
							<option value="Botswana">Botswana</option>
							<option value="Bouvet Island">Bouvet Island</option>
							<option value="Brazil">Brazil</option>
							<option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
							<option value="Brunei Darussalam">Brunei Darussalam</option>
							<option value="Bulgaria">Bulgaria</option>
							<option value="Burkina Faso">Burkina Faso</option>
							<option value="Burundi">Burundi</option>
							<option value="Cambodia">Cambodia</option>
							<option value="Cameroon">Cameroon</option>
							<option value="Canada">Canada</option>
							<option value="Cape Verde">Cape Verde</option>
							<option value="Cayman Islands">Cayman Islands</option>
							<option value="Central African Republic">Central African Republic</option>
							<option value="Chad">Chad</option>
							<option value="Chile">Chile</option>
							<option value="China">China</option>
							<option value="Christmas Island">Christmas Island</option>
							<option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
							<option value="Colombia">Colombia</option>
							<option value="Comoros">Comoros</option>
							<option value="Congo">Congo</option>
							<option value="Congo, The Democratic Republic of The">Congo, The Democratic Republic of The</option>
							<option value="Cook Islands">Cook Islands</option>
							<option value="Costa Rica">Costa Rica</option>
							<option value="Cote D'ivoire">Cote D'ivoire</option>
							<option value="Croatia">Croatia</option>
							<option value="Cuba">Cuba</option>
							<option value="Cyprus">Cyprus</option>
							<option value="Czech Republic">Czech Republic</option>
							<option value="Denmark">Denmark</option>
							<option value="Djibouti">Djibouti</option>
							<option value="Dominica">Dominica</option>
							<option value="Dominican Republic">Dominican Republic</option>
							<option value="Ecuador">Ecuador</option>
							<option value="Egypt">Egypt</option>
							<option value="El Salvador">El Salvador</option>
							<option value="Equatorial Guinea">Equatorial Guinea</option>
							<option value="Eritrea">Eritrea</option>
							<option value="Estonia">Estonia</option>
							<option value="Ethiopia">Ethiopia</option>
							<option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
							<option value="Faroe Islands">Faroe Islands</option>
							<option value="Fiji">Fiji</option>
							<option value="Finland">Finland</option>
							<option value="France">France</option>
							<option value="French Guiana">French Guiana</option>
							<option value="French Polynesia">French Polynesia</option>
							<option value="French Southern Territories">French Southern Territories</option>
							<option value="Gabon">Gabon</option>
							<option value="Gambia">Gambia</option>
							<option value="Georgia">Georgia</option>
							<option value="Germany">Germany</option>
							<option value="Ghana">Ghana</option>
							<option value="Gibraltar">Gibraltar</option>
							<option value="Greece">Greece</option>
							<option value="Greenland">Greenland</option>
							<option value="Grenada">Grenada</option>
							<option value="Guadeloupe">Guadeloupe</option>
							<option value="Guam">Guam</option>
							<option value="Guatemala">Guatemala</option>
							<option value="Guernsey">Guernsey</option>
							<option value="Guinea">Guinea</option>
							<option value="Guinea-bissau">Guinea-bissau</option>
							<option value="Guyana">Guyana</option>
							<option value="Haiti">Haiti</option>
							<option value="Heard Island and Mcdonald Islands">Heard Island and Mcdonald Islands</option>
							<option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option>
							<option value="Honduras">Honduras</option>
							<option value="Hong Kong">Hong Kong</option>
							<option value="Hungary">Hungary</option>
							<option value="Iceland">Iceland</option>
							<option value="India">India</option>
							<option value="Indonesia">Indonesia</option>
							<option value="Iran, Islamic Republic of">Iran, Islamic Republic of</option>
							<option value="Iraq">Iraq</option>
							<option value="Ireland">Ireland</option>
							<option value="Isle of Man">Isle of Man</option>
							<option value="Israel">Israel</option>
							<option value="Italy">Italy</option>
							<option value="Jamaica">Jamaica</option>
							<option value="Japan">Japan</option>
							<option value="Jersey">Jersey</option>
							<option value="Jordan">Jordan</option>
							<option value="Kazakhstan">Kazakhstan</option>
							<option value="Kenya">Kenya</option>
							<option value="Kiribati">Kiribati</option>
							<option value="Korea, Democratic People's Republic of">Korea, Democratic People's Republic of</option>
							<option value="Korea, Republic of">Korea, Republic of</option>
							<option value="Kuwait">Kuwait</option>
							<option value="Kyrgyzstan">Kyrgyzstan</option>
							<option value="Lao People's Democratic Republic">Lao People's Democratic Republic</option>
							<option value="Latvia">Latvia</option>
							<option value="Lebanon">Lebanon</option>
							<option value="Lesotho">Lesotho</option>
							<option value="Liberia">Liberia</option>
							<option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
							<option value="Liechtenstein">Liechtenstein</option>
							<option value="Lithuania">Lithuania</option>
							<option value="Luxembourg">Luxembourg</option>
							<option value="Macao">Macao</option>
							<option value="Macedonia, The Former Yugoslav Republic of">Macedonia, The Former Yugoslav Republic of</option>
							<option value="Madagascar">Madagascar</option>
							<option value="Malawi">Malawi</option>
							<option value="Malaysia">Malaysia</option>
							<option value="Maldives">Maldives</option>
							<option value="Mali">Mali</option>
							<option value="Malta">Malta</option>
							<option value="Marshall Islands">Marshall Islands</option>
							<option value="Martinique">Martinique</option>
							<option value="Mauritania">Mauritania</option>
							<option value="Mauritius">Mauritius</option>
							<option value="Mayotte">Mayotte</option>
							<option value="Mexico">Mexico</option>
							<option value="Micronesia, Federated States of">Micronesia, Federated States of</option>
							<option value="Moldova, Republic of">Moldova, Republic of</option>
							<option value="Monaco">Monaco</option>
							<option value="Mongolia">Mongolia</option>
							<option value="Montenegro">Montenegro</option>
							<option value="Montserrat">Montserrat</option>
							<option value="Morocco">Morocco</option>
							<option value="Mozambique">Mozambique</option>
							<option value="Myanmar">Myanmar</option>
							<option value="Namibia">Namibia</option>
							<option value="Nauru">Nauru</option>
							<option value="Nepal">Nepal</option>
							<option value="Netherlands">Netherlands</option>
							<option value="Netherlands Antilles">Netherlands Antilles</option>
							<option value="New Caledonia">New Caledonia</option>
							<option value="New Zealand">New Zealand</option>
							<option value="Nicaragua">Nicaragua</option>
							<option value="Niger">Niger</option>
							<option value="Nigeria">Nigeria</option>
							<option value="Niue">Niue</option>
							<option value="Norfolk Island">Norfolk Island</option>
							<option value="Northern Mariana Islands">Northern Mariana Islands</option>
							<option value="Norway">Norway</option>
							<option value="Oman">Oman</option>
							<option value="Pakistan">Pakistan</option>
							<option value="Palau">Palau</option>
							<option value="Palestinian Territory, Occupied">Palestinian Territory, Occupied</option>
							<option value="Panama">Panama</option>
							<option value="Papua New Guinea">Papua New Guinea</option>
							<option value="Paraguay">Paraguay</option>
							<option value="Peru">Peru</option>
							<option value="Philippines">Philippines</option>
							<option value="Pitcairn">Pitcairn</option>
							<option value="Poland">Poland</option>
							<option value="Portugal">Portugal</option>
							<option value="Puerto Rico">Puerto Rico</option>
							<option value="Qatar">Qatar</option>
							<option value="Reunion">Reunion</option>
							<option value="Romania">Romania</option>
							<option value="Russian Federation">Russian Federation</option>
							<option value="Rwanda">Rwanda</option>
							<option value="Saint Helena">Saint Helena</option>
							<option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
							<option value="Saint Lucia">Saint Lucia</option>
							<option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option>
							<option value="Saint Vincent and The Grenadines">Saint Vincent and The Grenadines</option>
							<option value="Samoa">Samoa</option>
							<option value="San Marino">San Marino</option>
							<option value="Sao Tome and Principe">Sao Tome and Principe</option>
							<option value="Saudi Arabia">Saudi Arabia</option>
							<option value="Senegal">Senegal</option>
							<option value="Serbia">Serbia</option>
							<option value="Seychelles">Seychelles</option>
							<option value="Sierra Leone">Sierra Leone</option>
							<option value="Singapore">Singapore</option>
							<option value="Slovakia">Slovakia</option>
							<option value="Slovenia">Slovenia</option>
							<option value="Solomon Islands">Solomon Islands</option>
							<option value="Somalia">Somalia</option>
							<option value="South Africa">South Africa</option>
							<option value="South Georgia and The South Sandwich Islands">South Georgia and The South Sandwich Islands</option>
							<option value="Spain">Spain</option>
							<option value="Sri Lanka">Sri Lanka</option>
							<option value="Sudan">Sudan</option>
							<option value="Suriname">Suriname</option>
							<option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
							<option value="Swaziland">Swaziland</option>
							<option value="Sweden">Sweden</option>
							<option value="Switzerland">Switzerland</option>
							<option value="Syrian Arab Republic">Syrian Arab Republic</option>
							<option value="Taiwan, Province of China">Taiwan, Province of China</option>
							<option value="Tajikistan">Tajikistan</option>
							<option value="Tanzania, United Republic of">Tanzania, United Republic of</option>
							<option value="Thailand">Thailand</option>
							<option value="Timor-leste">Timor-leste</option>
							<option value="Togo">Togo</option>
							<option value="Tokelau">Tokelau</option>
							<option value="Tonga">Tonga</option>
							<option value="Trinidad and Tobago">Trinidad and Tobago</option>
							<option value="Tunisia">Tunisia</option>
							<option value="Turkey">Turkey</option>
							<option value="Turkmenistan">Turkmenistan</option>
							<option value="Turks and Caicos Islands">Turks and Caicos Islands</option>
							<option value="Tuvalu">Tuvalu</option>
							<option value="Uganda">Uganda</option>
							<option value="Ukraine">Ukraine</option>
							<option value="United Arab Emirates">United Arab Emirates</option>
							<option value="United Kingdom">United Kingdom</option>
							<option value="United States">United States</option>
							<option value="United States Minor Outlying Islands">United States Minor Outlying Islands</option>
							<option value="Uruguay">Uruguay</option>
							<option value="Uzbekistan">Uzbekistan</option>
							<option value="Vanuatu">Vanuatu</option>
							<option value="Venezuela">Venezuela</option>
							<option value="Viet Nam">Viet Nam</option>
							<option value="Virgin Islands, British">Virgin Islands, British</option>
							<option value="Virgin Islands, U.S.">Virgin Islands, U.S.</option>
							<option value="Wallis and Futuna">Wallis and Futuna</option>
							<option value="Western Sahara">Western Sahara</option>
							<option value="Yemen">Yemen</option>
							<option value="Zambia">Zambia</option>
							<option value="Zimbabwe">Zimbabwe</option>
						</select>
 
				  </div>
				</div>
				
				<!-- PROIZVODJAC input-->
				<div class="form-group">
				  <label  for="textinput">Naziv proizvodjaca</label>  
				  <div>
				  <input id="producer" name="producer" placeholder="Unesite naziv proizvodjaca" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				
				<!-- PRICE input-->
				<div class="form-group">
				  <label  for="textinput">Cena proizvoda</label>  
				  <input id="price" name="price" placeholder="Unesite cenu proizvoda(u dinarima)" smk-type="number" minlength="2" maxlength="15" class="form-control input-md" type="text" required>  
				  <div>
				  </div>
				</div>
				
				
				<!-- KOLICINA input-->
				<div class="form-group">
				  <label  for="textinput">Kolicina proizvoda na lageru</label>  
				  <input id="quantity" name="quantity" placeholder="quantity" smk-type="number" minlength="1" maxlength="15" class="form-control input-md" type="text" required>  
				  <div>
				  </div>
				</div>
				
				
				<!-- KATEGORIJA input-->
				<div class="form-group">
				  <label  for="textinput">Izaberi kategoriju namestaja</label>  
				  <div>
				         <select id="category" name="category" class="form-control" required>
							<option value="">Izaberite kategoriju</option>
							<c:forEach items="${category}" var="k">
							
								<option value="${k.name}">${k.name}</option>
							
							</c:forEach>
							
						</select>
 
				  </div>
				</div>
				
				<!-- SALON input-->
				<div class="form-group">
				  <label  for="textinput">Izaberi salon namestaja</label>  
				  <div>
				         <select id="salon" name="salon" class="form-control" required>
							<option value="">Izaberite kategoriju</option>
							<c:forEach items="${salons}" var="s">
							
								<option value="${s.name}">${s.name}</option>
							
							</c:forEach>
							
						</select>
 
				  </div>
				</div>
				
				
				
				
				<!-- YEAR input-->
				<div class="form-group">
				  <label  for="textinput">Godina proizvodnje namestaja</label>  
				  <div>
				  <input id="productionYear" name="productionYear" placeholder="Unesite godinu proivodnje namestaja" class="form-control input-md" smk-type="number" minlength="3" maxlength="4"  type="text" required>  
				  </div>
				</div>
				
				
				
				<!-- AKCIJA input-->
				<div class="form-group">
				  <label  for="textinput">Da li je na akciji?</label>  
				  <div>
				         <select id="action" name="action" class="form-control" required>
							<option value="">Izaberite:</option>
							<option value="da">da</option>
							<option value="ne">ne</option>
						</select>
 
				  </div>
				</div>
				
				
				<!-- STARTDATE input-->
				<div class="form-group" id="start">
				  <label  for="textinput">Datum pocetka akcije</label>  
				  <div class="hero-unit">
				  <input id="startDate" name="startDate" placeholder="Kliknite za izbor datuma"  type="text">  
				  </div>
				</div>
				
				<!-- ENDDATE input-->
				<div class="form-group" id="end">
				  <label  for="textinput">Datum kraja akcije</label>  
				  <div class="hero-unit">
				  <input id="endDate" name="endDate" placeholder="Kliknite za izbor datuma"  type="text">  
				  </div>
				</div>
				
				<!-- AKCIJA input-->
				<div class="form-group" id="akcija">
				  <label  for="textinput">Procenat popusta?</label>  
				  <div>
				         <select id="percent" name="percent" class="form-control">
							<option value="">Izaberite:</option>
							<option value="10">10%</option>
							<option value="20">20%</option>
							<option value="30">30%</option>
							<option value="40">40%</option>
							<option value="50">50%</option>
							<option value="60">60%</option>
							<option value="70">70%</option>
							<option value="80">80%</option>
							<option value="90">90%</option>
							
						</select>
 
				  </div>
				</div>
				
				<!-- SALON input-->
				<div class="form-group">
				  <label  for="textinput">Izaberi besplatnu uslugu</label>  
				  <div>
				         <select id="freeService" name="freeService" class="form-control" required>
							<option value="">Izaberite kategoriju</option>
							<option value="ne">Bez besplatne usluge</option>
							<c:forEach items="${services}" var="ser">
							
								<option value="${ser.name}">${ser.name}</option>
							
							</c:forEach>
							
						</select>
 
				  </div>
				</div>
				
				<!-- PROIZVODJAC input-->
				<div class="form-group">
				  <label  for="textinput">Link do videa</label>  
				  <div>
				  <input id="video" name="video" placeholder="Unesite link videa sa youtube-a" class="form-control input-md" type="text">  
				  </div>
				</div>
								
				<!-- PROIZVODJAC input-->
				<div class="form-group">
				  <label  for="textinput">Link do slike</label>  
				  <div>
				  <input id="picture" name="picture" placeholder="Unesite link ili putanju do slike" class="form-control input-md" type="text">  
				  </div>
				</div>
				
														<input type="hidden" name="user_id" value="${user}"></input>
				
				

				 <button  name="salonButton"  id="dugme" type="submit" class="btn btn-default">Unesi namestaj</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
