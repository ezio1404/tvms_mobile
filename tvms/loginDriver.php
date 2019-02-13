<?php
include 'dbconn.php';


// $driver_email = $_POST['driver_email'];
// $driver_password = $_POST['driver_password'];
$driver_email = "zumign1404@gmail.com";
$driver_password = "";

$status = loginDriver(array($driver_email, $driver_password), array('driver_email', 'driver_password'));
echo json_encode($status);