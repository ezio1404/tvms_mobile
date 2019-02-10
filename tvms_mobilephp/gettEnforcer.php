<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $enforcer_id = $_POST['enforcer_id'];

    require_once 'connect.php';

    $sql = "SELECT * FROM enforcer WHERE enforcer_id='$enforcer_id' ";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['read'] = array();

    if( mysqli_num_rows($response) === 1 ) {
        
        if ($row = mysqli_fetch_assoc($response)) {
 
             $h['enforcer_lname']        = $row['enforcer_lname'] ;
             $h['enforcer_email']       = $row['enforcer_email'] ;
 
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