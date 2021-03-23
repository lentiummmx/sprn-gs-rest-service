package com.globant.restservice.evt_src_cqrs.cqrs.aggregators;

import com.globant.restservice.evt_src_cqrs.base.models.User;
import com.globant.restservice.evt_src_cqrs.cqrs.commands.CreateUserCommand;
import com.globant.restservice.evt_src_cqrs.cqrs.commands.UpdateUserCommand;
import com.globant.restservice.evt_src_cqrs.cqrs.repositories.UserWriteRepository;

public class UserAggregate {
    private UserWriteRepository writeRepository;

    public UserAggregate(UserWriteRepository writeRepository) {
        this.writeRepository = writeRepository;
    }

    public User handleCreateUserCommand(CreateUserCommand command) {
        User user = new User(command.getUserId(), command.getFirstName(), command.getFirstName());
        writeRepository.addUser(user.getUserId(), user);
        return user;
    }

    public User handleUpdateUserCommand(UpdateUserCommand command) {
        User user = writeRepository.getUser(command.getUserId());
        user.setAddresses(command.getAddresses());
        user.setContacts(command.getContacts());
        writeRepository.addUser(user.getUserId(), user);
        return user;
    }
}
