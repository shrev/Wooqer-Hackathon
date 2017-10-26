<?php
$con=mysqli_connect("localhost","root","","wooqer");

//print_r($_POST);

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else
{
	//echo "Database connection successful";
}

$first_name = $_POST['first_name'];
$last_name = $_POST['last_name'];

// $_GET['last_name'];
//$_GET['first_name'];

$result = mysqli_query($con,"SELECT * FROM details where first_name = '$first_name' and last_name ='$last_name'");
if (mysqli_query($con,"SELECT * FROM details where first_name = '$first_name' and last_name ='$last_name'"))
{
   //echo "fetch successful";
}
else 
{
	echo mysqli_error($con);
}
$row = mysqli_fetch_array($result);
$fn = $row[0];
$ln = $row[1];
$sc = json_encode($row[2]);
$sig = $row[3];
$lat = $row[4];
$lon = $row[5];

//if(!$fn) echo " n0 name";

//echo $fn ;
//echo $sig;

$xml = new SimpleXMLElement('<xml/>');


     $xml->addChild('first_name',$fn);
	 $xml->addChild('last_name',$ln);
	 $xml->addChild('secret_key',$sc);
	 $xml->addChild('latitude',$lat);
	 $xml->addChild('longitude',$lon);
	 $xml->addChild('signature',$sig);
    


Header('Content-type: text/xml; charset=utf-8');
print($xml->asXML());

mysqli_close($con);
?>