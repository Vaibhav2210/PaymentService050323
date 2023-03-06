<?php

$curl = curl_init();

$Firstname = $_POST['firstname'];
$Lastname = $_POST['lastname'];
$Phone = $_POST['phone'];
$Email = $_POST['email'];
$Amount = $_POST['amount'];
$Currency = $_POST['currency'];
$PeerBankCode = $_POST['peerBankCode'];




// Sample request string for the API call
$merchant_json_data = array(
    'firstname' => $Firstname ,
    'lastname' => $Lastname ,
    'phone' => $Phone ,
    'email' => $Email,
    'amount' => $Amount ,
    'currency' => $Currency ,
    'peerBankCode' => $PeerBankCode 
);


// Generate json data after call below method
$merchant_data = json_encode($merchant_json_data);
//print_r($merchant_data);

//print_r($merchant_data);



curl_setopt_array($curl, array(
  CURLOPT_URL => 'localhost:8080/User',
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => '',
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 0,
  CURLOPT_FOLLOWLOCATION => true,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => 'POST',
  CURLOPT_POSTFIELDS =>$merchant_data,
  CURLOPT_HTTPHEADER => array(
    'Content-Type: application/json'
  ),
));



$response = curl_exec($curl);

$apiResponse = json_decode($response, true);

$respfname = $apiResponse['firstname'];
$resplname = $apiResponse['lastname'];
$respphone = $apiResponse['phone'];
$respemail = $apiResponse['email'];
$respamount = $apiResponse['amount'];
$respcurrency = $apiResponse['currency'];
$resppeerbankcode = $apiResponse['peerBankCode'];

$resppeerBankName = $apiResponse['peerBankName'];
$resppeerBankBranch = $apiResponse['peerBankBranch'];
$resppid = $apiResponse['pid'];
$respstatus = $apiResponse['status'];
$respuvr = $apiResponse['uvr'];
$resptransactionid = $apiResponse['transactionid'];


echo "<B>Transaction ID: </B>".$resptransactionid;
echo "<br>";

echo "<B>UVR: </B>".$respuvr;
echo "<br>";

echo "<B>Status: </B>".$respstatus;
echo "<br>";

echo "<B>PID: </B>".$resppid;
echo "<br>";

echo "<B>Bank Code: </B>".$resppeerbankcode;
echo "<br>";

echo "<B>Bank Name: </B>".$resppeerBankName;
echo "<br>";

echo "<B>Branch Name: </B>".$resppeerBankBranch;
echo "<br>";

echo "<B>Firstname: </B>".$respfname;
echo "<br>";

echo "<B>Lastname: </B>".$resplname;
echo "<br>";

echo "<B>Phone Number: </B>".$respphone;
echo "<br>";

echo "<B>Amount: </B>".$respamount;
echo "<br>";

echo "<B>Currency </B>".$respcurrency;
echo "<br>";

echo "<B>Email ID: </B>".$respemail;
echo "<br>";




/*echo $resppeerbankcode;
echo "<br>";
echo $respemail;

/*foreach($apiResponse as $value){
  print_r($value);
}

echo '<script type ="text/JavaScript">';  
echo 'alert(" Transaction Initiated !!!! ")';  
echo '</script>';*/
curl_close($curl);  
?>