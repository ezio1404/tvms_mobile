<?php
include 'dbconn.php';


$enforcer_email = $_POST['enforcer_email'];
$enforcer_password = $_POST['enforcer_password'];

$status = loginEnforcer(array($enforcer_email, $enforcer_password), array('enforcer_email', 'enforcer_password'));
echo json_encode($status);