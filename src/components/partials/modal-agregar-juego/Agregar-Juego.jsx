import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import CloseButton from 'react-bootstrap/CloseButton';
import "./Agregar-Juego.css"


function AgregarJuego({closeModal}){   
    const [id,setId]=useState('');
    const [nombre,setNombre]=useState('');
    const [description,setDescription]=useState('');
    const [compania,setCompania]=useState({});
    const [imagen,setImagen]=useState('');
    const [fechaLanzamiento,setFechaLanzamiento]=useState('');
    const [consolas,setConsolas]=useState([]);


    return (
        <div id='modalJuegos' className='modalBackground'>            
            <div className='modalContainer'>                
                <div className='titleCloseBtn'>  
                <CloseButton  onClick={() => {
                        closeModal(false)}}></CloseButton>                                                      
                </div>
                <div className='title'>
                <h2>Agregar Juego</h2>
                </div>
                <div className='body'>
                    <form>
                    <input type='text' id='nombre' placeholder='Nombre'></input>
                    <input type='text' id='descripcion' placeholder='Descripción'></input>
                    <input type='text' id='consola' placeholder='Consola'></input>
                    <input type='text' id='compania' placeholder='Compañia'></input>
                    
                    <div className='footer'>
                    <Button id='addBtn' type='button'>Agregar</Button>
                    </div>
                    </form>
                </div>
                
            </div>
        </div>
    )
}

export default AgregarJuego;