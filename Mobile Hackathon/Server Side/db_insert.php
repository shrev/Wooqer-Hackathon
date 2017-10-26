<?php

$con=mysqli_connect("localhost","root","");
$sql="use wooqer";


if (mysqli_query($con,$sql))
{
  echo "Database connection successful";
}
else 
{
	echo "problem";
}

//print_r($_POST);

$first_name = $_POST['first_name'];
$last_name = $_POST['last_name'];
$secret_key = $_POST['secret_key'];
$signature = $_POST['signature'];
$latitude =$_POST['latitude'];
$longitude = $_POST['longitude'];


//
//

$sql="INSERT INTO details VALUES ('$first_name', '$last_name','$secret_key','$signature',$latitude,$longitude)";
if (mysqli_query($con,$sql))
{
   echo "Values have been inserted successfully";
}
else 
{
	echo mysqli_error($con);
}
?>