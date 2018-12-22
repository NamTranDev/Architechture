/**
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${packageName}

<#if !isDomain>
import dev.tran.nam.download.model.${datato}
import nam.tran.domain.entity.${datafrom}
import nam.tran.domain.entity.state.Resource
<#else>
import nam.tran.domain.entity.${datato}
import nam.tran.flatform.model.response.${datafrom}
</#if>

import java.util.*
import javax.inject.Inject

/**
 * Mapper class used to transform [${datafrom}] (in the <#if isDomain> in flatform layer<#else> in domain layer</#if>)
 * to [${datato}] in the
 * <#if isDomain> domain layer <#else> app layer</#if>.
 */
class ${DataMapperName} @Inject constructor() {

    /**
     * Transform a [${datafrom}] into an [${datato}].
     *
     * @param data Object to be transformed.
     * @return [${datato}].
     */
    fun transform(data: ${datafrom}?): ${datato} {
        data?.let {
	            val result = ${datato}()
	        	return result
        }
    }

    /**
     * Transform a Collection of [${datafrom}] into a Collection of [${datato}].
     *
     * @param datas Objects to be transformed.
     * @return List of [${datato}].
     */
    fun transform<#if isDomain>Entity<#else>Model</#if>(datas: List<${datafrom}>?): List<${datato}> {
        val <#if isDomain>dataEntitys<#else>dataModels</#if>: MutableList<${datato}>

        if (datas != null && !datas.isEmpty()) {
            <#if isDomain>dataEntitys<#else>dataModels</#if> = ArrayList()
            for (data in datas) {
                <#if isDomain>dataEntitys<#else>dataModels</#if>.add(transform(data))
            }
        } else {
            <#if isDomain>dataEntitys<#else>dataModels</#if> = ArrayList()
        }

        return <#if isDomain>dataEntitys<#else>dataModels</#if>
    }

    <#if isReverse>

    /**
     * Transform a [${datato}] into an [${datafrom}].
     *
     * @param data Object to be transformed.
     * @return [${datafrom}].
     */
    fun transform(data: ${datato}?): ${datafrom} {
        data?.let {
	            val result = ${datafrom}()
	        	return result
        }
    }

    /**
     * Transform a Collection of [${datato}] into a Collection of [${datafrom}].
     *
     * @param datas Objects to be transformed.
     * @return List of [${datafrom}].
     */
    fun transform(datas: List<${datato}>?): List<${datafrom}> {
        val data: MutableList<${datafrom}>

        if (datas != null && !datas.isEmpty()) {
            data = ArrayList()
            for (dataItem in datas) {
                data.add(transform(dataItem))
            }
        } else {
            data = ArrayList()
        }

        return data
    }

    </#if>

    <#if !isDomain>
    fun transform(data: Resource<List<${datafrom}>>): Resource<List<${datato}>> {
        return Resource(data.status, transformModel(data.data), data.errorResource, data.loading, data.retry)
    }
    </#if>
}
