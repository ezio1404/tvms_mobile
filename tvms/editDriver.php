<?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $driver_lname = $_POST['driver_lname'];
    $driver_email = $_POST['driver_email'];
    $driver_id = $_POST['driver_id'];

    require_once 'connect.php';

    $sql = "UPDATE driver SET name='$name', driver_email='$driver_email' WHERE driver_id='$driver_id' ";

    if(mysqli_query($conn, $sql)) {

          $result["success"] = "1";
          $result["message"] = "success";

          echo json_encode($result);
          mysqli_close($conn);
      }
  }

else{

   $result["success"] = "0";
   $result["message"] = "error!";
   echo json_encode($result);

   mysqli_close($conn);
}

?>


