import React,{useEffect, useState} from 'react'
import axios from 'axios';
import Swal from 'sweetalert2'

import Col from  'react-bootstrap/Col';
import Row from  'react-bootstrap/Row';
import Juego from '../juego/Juego'
import AgregarJuego from '../partials/modal-agregar-juego/Agregar-Juego';
import { mostrar_alerta } from '../../funciones';
import Navbar from '../partials/navbar/Navbar';
import ListConsolas from '../partials/ListConsolas';


const Contenido = () => {    

    return(
            <div className='container-fluid'>
                <Navbar/>
                <ListConsolas/>

            </div>
    )
}

export default Contenido;