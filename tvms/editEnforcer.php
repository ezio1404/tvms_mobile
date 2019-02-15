<?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $enforcer_lname = $_POST['enforcer_lname'];
    $enforcer_email = $_POST['enforcer_email'];
    $enforcer_id = $_POST['enforcer_id'];

    require_once 'connect.php';

    $sql = "UPDATE enforcer SET name='$name', enforcer_email='$enforcer_email' WHERE enforcer_id='$enforcer_id' ";

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


