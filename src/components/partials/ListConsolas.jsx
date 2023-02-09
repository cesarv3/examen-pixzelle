import React,{useEffect, useState} from 'react';
import { MDBTable, MDBTableHead, MDBTableBody } from 'mdb-react-ui-kit';
import Button from 'react-bootstrap/Button';
import axios from 'axios';
import { mostrar_alerta } from '../../funciones';

import AgregarConsola from './modal-agregar-consola/Agregar-Consola';

const ListConsolas = () => {
    const url = 'http://localhost:8080/consola/all';
    let urlDelete = 'http://localhost:8080/consola/';
    const [consolas,setConsolas] = useState([]);    
    const [isOpen,setOpen] = useState(false);
    const [metodo,setMetodo] = useState(0);
    const [consola,setConsola] = useState({});

    useEffect(() => {
        getConsolas();
    },[]);

    const getConsolas = async () => {
        const respuesta = await axios.get(url);
        setConsolas(respuesta.data._embedded.consolaDataList);
        
    }

    const eliminarConsola = async (consolaId) => {
        console.log(consolaId);
        if(consolaId){
            urlDelete = urlDelete + consolaId;
            await axios({method:'DELETE', url: urlDelete})
            .then(function(respuesta){
                console.log(respuesta);
                getConsolas();
            })
            .catch(function(error){
                mostrar_alerta("Error al tratar de eliminar.",'error')
                console.log(error);
            })
        }

        
    }

    
    return(
        <div className='container-fluid'>
            <div className='row mt-3'>
            <Button onClick={() => {
                                setMetodo(0);    
                                setOpen(true);
                                setConsola({});
                            }} className='btn btn-dark'>
                                <i className='fa-solid fa-circle-plus' ></i>  Agregar
                                </Button> 
        
        <MDBTable>
            <MDBTableHead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th></th>
                </tr>
            </MDBTableHead>
            <MDBTableBody>            
                

                {consolas.map((consola,id) => (                      
                    <tr key={consola.consola_id}>
                        <td>{consola.consola_id}</td>
                        <td>{consola.nombre}</td>
                        <td><Button onClick={() => {
                                setMetodo(1);
                                setOpen(true);
                                setConsola(consola);
                            }} variant='success'>Editar</Button>
                        <Button onClick={() => {
                            eliminarConsola(consola.consola_id);
                        }}
                        variant='danger'>Eliminar</Button></td>
                    </tr>
                                     
                ))}
            </MDBTableBody>
        </MDBTable>
        {isOpen && <AgregarConsola  selectedConsola={consola} metodoId={metodo} closeModal={setOpen} loadConsola={getConsolas}/>}
        </div>
        </div>
    )
}

export default ListConsolas;