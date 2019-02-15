<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $driver_id = $_POST['driver_id'];

    require_once 'connect.php';

    $sql = "SELECT * FROM driver WHERE driver_id='$driver_id' ";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['read'] = array();

    if( mysqli_num_rows($response) === 1 ) {
        
        if ($row = mysqli_fetch_assoc($response)) {
            $h['driver_fname']       = $row['driver_fname'] ;
             $h['driver_mi']       = $row['driver_mi'] ;
             $h['driver_lname']        = $row['driver_lname'] ;
             $h['driver_email']       = $row['driver_email'] ;
             $h['driver_pincode']       = $row['driver_pincode'] ;
             $h['driver_password']       = $row['driver_password'] ;
             array_push($result["read"], $h);
             $result["success"] = "1";
             echo json_encode($result);
        }
 
   }
 
 }else {
 
     $result["success"] = "0";
     $result["message"] = "Error!";
     echo json_encode($result);
 
     mysqli_close($conn);
 }
 
 ?>