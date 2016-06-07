<?php
    $data = array('Futebol', 'Corrida', 'Artes Marciais', 'Fitness');
    header('Content-Type: application/json');
    echo json_encode($data);
?>