/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nam.tran.domain.entity.state;

import android.support.annotation.Nullable;

import static nam.tran.domain.entity.state.Status.ERROR;
import static nam.tran.domain.entity.state.Status.SUCCESS;

/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Resource<T> {

    public final @Status int status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    public Resource(@Status int status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    public static <T> Resource<T> noneLoading(@Nullable T data) {
        return new Resource<>(Status.LOADING_NONE, data, null);
    }

    public static <T> Resource<T> normalLoading(@Nullable T data) {
        return new Resource<>(Status.LOADING_NORMAL, data, null);
    }

    public static <T> Resource<T> dialogLoading(@Nullable T data) {
        return new Resource<>(Status.LOADING_DIALOG, data, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Resource<?> resource = (Resource<?>) o;

        return status == resource.status
                && (message != null ? message.equals(resource.message) : resource.message == null)
                && (data != null ? data.equals(resource.data) : resource.data == null);
    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "status=" + getStatus(status) +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    private String getStatus(@Status int status) {
        switch (status) {
            case ERROR:
                return "Error";
            case Status.LOADING_DIALOG:
                return "Loading Dialog";
            case Status.LOADING_NONE:
                return "Loading None";
            case Status.LOADING_NORMAL:
                return "Loading Normal";
            case SUCCESS:
            default:
                return "Success";
        }
    }
}
