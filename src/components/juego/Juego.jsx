import React from 'react'
import Button from 'react-bootstrap/Button'
import Card from 'react-bootstrap/Card'

function Juego({id, nombre, descripcion,imagen}) {
    return (
        <Card style={{width: '18rem'}}>
            <Card.Img  src={imagen}/>
            <Card.Body>
                <Card.Title>{id + " - " + nombre}</Card.Title>
                <Card.Text>{descripcion}</Card.Text>                
            </Card.Body>
        </Card>

    );
}

export default Juego;