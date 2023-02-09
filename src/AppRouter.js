import React from 'react'
import {BrowserRouter, Routes, Route} from "react-router-dom"
import Contenido from './components/contenido/Contenido'
import DashboardAdmin from './components/dashboard-admin/DashboardAdmin'
import ListCompanias from './components/companias/ListCompanias'

function AppRouter() {
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/juegos" element={<Contenido/>} />
                <Route path="/consolas" element={<DashboardAdmin/>} />
                <Route path="/companias" element={<ListCompanias/>} />

                
            </Routes>
        </BrowserRouter>
    ) 
}

export default AppRouter;