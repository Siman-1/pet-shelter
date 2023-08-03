import React from 'react';

export default function Pet({pet}) {

    const removePet = (id) => {
        // correct fetch with api for deleting pet 
        fetch ("/api/pets/{petID}", {
            id: pet.id
        })
    }

    return (
        <div>
            
            <div>{pet.name}</div>
            <button onClick={() => removePet(pet.id)}>Delete</button>
        
        
        </div>
    )
}