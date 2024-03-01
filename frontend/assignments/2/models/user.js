const { v4: uuidv4 } = require('uuid');

class User {
    constructor() {
        this.users = [
            { id: uuidv4(), user_name: 'Sanskar', user_email_id: 'Sanskar@example.com', password: 'password1', profile_url: '' },
            { id: uuidv4(), user_name: 'NathuRam', user_email_id: 'NathuRam@example.com', password: 'password2', profile_url: '' },
            { id: uuidv4(), user_name: 'Veerbhadra', user_email_id: 'Veerbhadra@example.com', password: 'password3', profile_url: '' },
            { id: uuidv4(), user_name: 'Kalbhairav', user_email_id: 'Kalbhairav@example.com', password: 'password4', profile_url: '' },
            { id: uuidv4(), user_name: 'VikramAditya', user_email_id: 'VikramAditya@example.com', password: 'password5', profile_url: '' }
        ];
    }

    getUserById(id) {
        return this.users.find(user => user.id === id);
    }

    getAllUsers() {
        return this.users;
    }

    postUser(newUser) {
        newUser.id = uuidv4();
        this.users.push(newUser);
        return newUser;
    }

    verifyUser(username, password) {
        console.log(username);
        console.log(password);
    
        let foundUser = null;
        this.users.forEach(user => {
            console.log("User data:", user);
            if (user.user_name === username && user.password === password) {
                console.log("User found:", user);
                foundUser = user;
            }
        });
    
        return foundUser;
    }    
}

module.exports = User;
