import React,{useEffect, useState} from 'react';
import { MDBTable, MDBTableHead, MDBTableBody } from 'mdb-react-ui-kit';
import Button from 'react-bootstrap/Button';
import axios from 'axios';
import { mostrar_alerta } from '../../funciones';
import Navbar from '../partials/navbar/Navbar';
import AgregarCompania from '../partials/modal-agregar-compania/Agregar-Compania';

const ListCompanias = () => {
    const url = 'http://localhost:8080/compania/all';
    let urlDelete = 'http://localhost:8080/compania/';
    const [companias,setCompanias] = useState([]);    
    const [isOpen,setOpen] = useState(false);
    const [metodo,setMetodo] = useState(0);
    const [compania,setCompania] = useState({});

    useEffect(() => {
        getCompanias();
    },[]);

    const getCompanias = async () => {
        const respuesta = await axios.get(url);
        setCompanias(respuesta.data._embedded.companiaDataList);
        
    }

    const eliminarCompania = async (companiaId) => {
        console.log(companiaId);
        if(companiaId){
            urlDelete = urlDelete + companiaId;
            await axios({method:'DELETE', url: urlDelete})
            .then(function(respuesta){
                console.log(respuesta);
                getCompanias();
            })
            .catch(function(error){
                mostrar_alerta("Error al tratar de eliminar.",'error')
                console.log(error);
            })
        }

        
    }

    
    return(
        <div className='container-fluid'>
            <Navbar/>
            <div className='row mt-3'>
            <Button onClick={() => {
                                setMetodo(0);    
                                setOpen(true);
                                setCompania({});
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
                

                {companias.map((compania,id) => (                      
                    <tr key={compania.compania_id}>
                        <td>{compania.compania_id}</td>
                        <td>{compania.nombre}</td>
                        <td><Button onClick={() => {
                                setMetodo(1);
                                setOpen(true);
                                setCompania(compania);
                            }} variant='success'>Editar</Button>
                        <Button onClick={() => {
                            eliminarCompania(compania.compania_id);
                        }}
                        variant='danger'>Eliminar</Button></td>
                    </tr>
                                     
                ))}
            </MDBTableBody>
        </MDBTable>
        {isOpen && <AgregarCompania  selectedCompania={compania} metodoId={metodo} closeModal={setOpen} loadCompania={getCompanias}/>}
        </div>
        </div>
    )
}

export default ListCompanias;