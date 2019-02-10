<?php

function conn(){
	try{
		return new PDO("mysql:hostname=localhost;dbname=tvms","root","");
	}catch(PDOException $e){
		echo $e->getMessage();
	}
}

function addRecord($data,$fields,$table){
    $conn = conn();
    $flds = implode(",",$fields);
    $val = array();
    foreach($data as $d)
    $val[] = "?";
    $values = implode(",",$val);
    $sql = "INSERT INTO $table($flds) VALUES($values)";
    $stmt = $conn->prepare($sql);
$stmt->execute($data);

}