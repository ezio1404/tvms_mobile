<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $driver_email = $_POST['driver_email'];
    $driver_password = $_POST['driver_password'];


    require_once 'connect.php';

    $sql = "SELECT * FROM driver WHERE driver_email='$driver_email' ";

    $response = mysqli_query($conn, $sql);

    //
    $result = array();
    $result['login'] = array();
    
    if ( mysqli_num_rows($response) === 1 ) {
        

        if ( $driver_password== $row['driver_password'] ) {
            
            // $index['driver_lname'] = $row['driver_lname'];
            $index['driver_email'] = $row['driver_email'];
            $index['driver_id'] = $row['driver_id'];

            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($conn);

        }

    }

}

?>