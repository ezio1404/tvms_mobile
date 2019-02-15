<?php 
 if ($_SERVER['REQUEST_METHOD']=='POST') {


 	 $agency_id = $_POST['agency_id'];
    $driver_id = $_POST['driver_id'];
    $plate_no = $_POST['plate_no'];

    require_once 'connect.php';

    $sql = "INSERT INTO clearance (driver_id , agency_id, plateNo) VALUES ('$driver_id', '$agency_id', '$plate_no') ";

    $response = mysqli_query($conn, $sql);

    
    if ( $response ) {
        


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

?>